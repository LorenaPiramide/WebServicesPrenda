package com.cpifppiramide.prueba1.dao.prendas;

import com.cpifppiramide.prueba1.context.DBConnection;
import com.cpifppiramide.prueba1.entidades.Ejemplar;
import com.cpifppiramide.prueba1.entidades.Prenda;
import com.cpifppiramide.prueba1.entidades.TipoPrenda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOPrendasMySQL implements DAOPrendas {
    @Override
    public List<Prenda> lista() {
        List<Prenda> prendas = new ArrayList<>();

        try {
            //String query = "SELECT *, (SELECT COUNT(*) FROM ejemplares e WHERE e.prenda = p.marca) AS numPrendas FROM prendas p";
            String query = "SELECT * FROM prendas";
            PreparedStatement ps = DBConnection.getInstance().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prenda prenda = new Prenda(
                        rs.getString("marca"),
                        TipoPrenda.valueOf(rs.getString("tipoPrenda"))
                );
                // todo si pongo la consulta de count, al pasarlo a rest, no funciona, si pones solo mostrar las prendas y nada más, sale bien
//                int numPrendas = rs.getInt("numPrendas");
//                for (int i = 0; i < numPrendas; i++) {
//                    prenda.addEjemplar(new Ejemplar());
//                }
                prendas.add(prenda);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return prendas;
    }

    @Override
    public Prenda ver(String marca) {
        String query = "SELECT * FROM prendas WHERE marca = ?";
        try {
            PreparedStatement ps = DBConnection.getInstance().prepareStatement(query);
            ps.setString(1, marca);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Prenda(rs.getString("marca"), TipoPrenda.valueOf(rs.getString("tipoPrenda")));
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return null;
    }

    @Override
    public void inserta(Prenda prenda) {
        try {
            String query = "INSERT INTO prendas (marca, tipoPrenda) VALUES (?, ?)";
            PreparedStatement ps = DBConnection.getInstance().prepareStatement(query);
            ps.setString(1, prenda.getMarca());
            ps.setString(2, String.valueOf(prenda.getTipoPrenda()));
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
