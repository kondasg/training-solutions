package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private final List<Production> productions = new ArrayList<>();
    private final List<Vote> votes = new ArrayList<>();

    public List<Production> getProductions() {
        return productions;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void readTalents(Path talentsFile) {
        try (BufferedReader reader = Files.newBufferedReader(talentsFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(" ");
                productions.add(new Production(Integer.parseInt(splittedLine[0]), splittedLine[1]));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read " + talentsFile.toString() + " file", e);
        }
    }

    public void calculateVotes(Path votesFile) {
        try (BufferedReader reader = Files.newBufferedReader(votesFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                int id = Integer.parseInt(line);
                addVote(id);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can't read " + votesFile + " file", e);
        }
    }

    public void writeResultToFile(Path resultFile) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(Files.newBufferedWriter(resultFile)))) {
            for (Production production: productions) {
                writer.println(production.getId() + " " + production.getName() + " " + getVote(production.getId()));
            }
            writer.print(maxVote());
        } catch (IOException e) {
            throw new IllegalStateException("Can't write " + resultFile + " file", e);
        }
    }

    private void addVote(int id) {
        for (Vote vote: votes) {
            if (vote.getId() == id) {
                vote.incNum();
                return;
            }
        }
        votes.add(new Vote(id, 1));
    }

    private String maxVote() {
        int max = votes.get(0).getNumber();
        int id = votes.get(0).getId();
        for (Vote vote: votes) {
            if (max < vote.getNumber()) {
                id = vote.getId();
                max = vote.getNumber();
            }
        }
        for (Production production: productions) {
            if (production.getId() == id) {
                return "Winner: " + production.getName();
            }
        }
        throw new IllegalArgumentException("Nincs nyertes");
    }

    private int getVote(int id) {
        for (Vote vote: votes) {
            if (vote.getId() == id) {
                return vote.getNumber();
            }
        }
        throw new IllegalArgumentException("Nincs ilyen produkció");
    }
}
