package com.cpifppiramide.prueba1.dao.ejemplares;

import com.cpifppiramide.prueba1.context.DBConnection;
import com.cpifppiramide.prueba1.entidades.Color;
import com.cpifppiramide.prueba1.entidades.Ejemplar;
import com.cpifppiramide.prueba1.entidades.Prenda;
import com.cpifppiramide.prueba1.entidades.Talla;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOEjemplaresMySQL implements DAOEjemplares {
    @Override
    public List<Ejemplar> get(Prenda prenda) {
        List<Ejemplar> ejemplares = new ArrayList<>();
        try {
            String query = "SELECT * FROM ejemplares WHERE prenda = ?";
            PreparedStatement ps = DBConnection.getInstance().prepareStatement(query);
            ps.setString(1, prenda.getMarca());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ejemplar ejemplar = new Ejemplar(
                        prenda,
                        Color.valueOf(rs.getString("color")),
                        Talla.valueOf(rs.getString("talla")),
                        rs.getInt("stock")
                );
                ejemplares.add(ejemplar);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return ejemplares;
    }

    @Override
    public void inserta(Ejemplar ejemplar) {
        try {
            String query = "INSERT INTO ejemplares (prenda, color, talla, stock) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = DBConnection.getInstance().prepareStatement(query);
            ps.setString(1, ejemplar.getPrenda().getMarca()); // Pasamos la marca, no el ejemplar
            ps.setString(2, String.valueOf(ejemplar.getColor()));
            ps.setString(3, String.valueOf(ejemplar.getTalla()));
            ps.setInt(4, ejemplar.getStock());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
