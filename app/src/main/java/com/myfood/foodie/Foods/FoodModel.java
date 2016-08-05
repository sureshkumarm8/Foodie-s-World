package com.myfood.foodie.Foods;


/**
 * Project: Foodie
 * Package: com.myfood.foodie.Foods
 * Created by lusinabrian on 05/08/16 at 05:33
 * <p/>
 * Description: Model class that creates an instance of a single food item. This will contain the properties of a single food item, such as name, date posted, user who posted it(chef), recipe, ingredients, brief description
 */
public class FoodModel {
    /*fields*/
    private String foodName, chefName, briefDesc;
    private int thumbnail;

    /*constructor*/
    public FoodModel(){}

    /*constructor*/
    public FoodModel(String foodName, String chefName, String briefDesc, int thumbnail) {
        this.foodName = foodName;
        this.chefName = chefName;
        this.briefDesc = briefDesc;
        this.thumbnail = thumbnail;
    }

/*ACCESS METHODS*/

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
/*CLASS END*/
}
