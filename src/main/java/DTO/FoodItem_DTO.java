
package DTO;

public class FoodItem_DTO {
    private int id;
    private String name, description, urlImage, unitName;
    private int unitPrice, idCategory;

    public FoodItem_DTO() {
    }

    public FoodItem_DTO(int id, String name, String description, String urlImage, String unitName, int unitPrice, int idCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urlImage = urlImage;
        this.unitName = unitName;
        this.unitPrice = unitPrice;
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "FoodItem_DTO{" + "id=" + id + ", name=" + name + ", description=" + description + ", urlImage=" + urlImage + ", unitName=" + unitName + ", unitPrice=" + unitPrice + ", idCategory=" + idCategory + '}';
    }
    
    
            
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getUnitName() {
        return unitName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    
    
    
}
