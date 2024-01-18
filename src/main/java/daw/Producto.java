/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author antonio
 */
public class Producto {

    Random r1 = new Random();
    DecimalFormat dosDecimales = new DecimalFormat("#.##");

    private int idProducto;
    private String descripcion;
    private Categoria categoria;
    private Subcategoria subcategoria;
    private double precio;
    private Iva iva;
    private int stock;

    public Producto(String descripcion, Categoria categoria, Subcategoria subcategoria) {
        this.idProducto = r1.nextInt(1, 100_000);
        this.descripcion = descripcion;

        if (categoria == Categoria.COMIDA) {
            if (subcategoria == Subcategoria.CARNE || subcategoria == Subcategoria.PESCADO || subcategoria == Subcategoria.VERDURA) {
                this.categoria = categoria;
                this.subcategoria = subcategoria;
            }
        }

        if (categoria == Categoria.BEBIDA) {
            if (subcategoria == Subcategoria.ALCOHOLICA || subcategoria == Subcategoria.AGUA || subcategoria == Subcategoria.REFRESCO || subcategoria == Subcategoria.ZUMO) {
                this.categoria = categoria;
                this.subcategoria = subcategoria;
            }
        }

        if (categoria == Categoria.POSTRE) {
            if (subcategoria == Subcategoria.NULL) {
                this.categoria = categoria;
                this.subcategoria = subcategoria;
            }
        }

        this.precio = r1.nextDouble(5, 20);
        if (subcategoria == Subcategoria.REFRESCO || subcategoria == Subcategoria.ALCOHOLICA) {
            this.iva = Iva.IVA_21;
        } else {
            this.iva = Iva.IVA_10;
        }
        this.stock = r1.nextInt(20, 100);
    }

    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Iva getIva() {
        return iva;
    }

    public void setIva(Iva iva) {
        this.iva = iva;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idProducto;
        hash = 41 * hash + Objects.hashCode(this.descripcion);
        hash = 41 * hash + Objects.hashCode(this.categoria);
        hash = 41 * hash + Objects.hashCode(this.subcategoria);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.iva);
        hash = 41 * hash + this.stock;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (this.categoria != other.categoria) {
            return false;
        }
        if (this.subcategoria != other.subcategoria) {
            return false;
        }
        return this.iva == other.iva;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("idProducto=").append(idProducto);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", categoria=").append(categoria);
        sb.append(", subcategoria=").append(subcategoria);
        sb.append(", precio=").append(dosDecimales.format(precio));
        sb.append(", iva=").append(iva);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }

}
