package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class TShirt extends Product {

    private String manufacturer;

    public TShirt(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt tShirt = (TShirt) o;
        return Objects.equals(getManufacturer(), tShirt.getManufacturer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getManufacturer());
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
