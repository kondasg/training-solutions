package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private final String name;
    private final List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkills(String... skills) {
        for (String skill : skills) {
            String[] result = skill.split(" \\(");
            this.skills.add(new Skill(result[0], Integer.parseInt(result[1].substring(0, 1))));
        }
    }

    public int findSkillLevelByName(String name) {
        int level = -1;
        for (Skill skill : skills) {
            if (name.equals(skill.getName())) {
                level = skill.getLevel();
            }
        }
        if (level == -1) {
            throw new SkillNotFoundException();
        } else {
            return level;
        }
    }
}
