package so.recenzija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Recenzija;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import so.AbstractSO;

public class SOAddRecenzija extends AbstractSO {

    private Recenzija recenzija;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Recenzija)) {
            throw new Exception("Prosleđeni objekat nije instanca klase Recenzija!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        recenzija = (Recenzija) ado;
        PreparedStatement ps = DBBroker.getInstance().insert(recenzija);
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            recenzija.setRecenzijaID(rs.getLong(1));
        }
    }

    public Recenzija getRecenzija() {
        return recenzija;
    }
}
