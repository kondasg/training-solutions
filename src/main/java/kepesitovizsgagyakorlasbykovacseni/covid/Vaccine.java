package kepesitovizsgagyakorlasbykovacseni.covid;

import javax.sql.DataSource;
import java.util.List;

public abstract class Vaccine {

    private final DataSource dataSource;

    public Vaccine(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public abstract List<Person> getVaccinationList();
}
