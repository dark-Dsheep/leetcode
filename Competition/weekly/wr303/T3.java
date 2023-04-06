package Competition.weekly.wr303;

import java.util.HashMap;
import java.util.TreeSet;

public class T3 {

    class FoodRatings {

        HashMap<String, Food> fMap = new HashMap<>();            // 食物名称 食物类
        HashMap<String, TreeSet<Food>> cfMap = new HashMap<>();  // 烹饪方式 食物有序集合

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                var food = new Food(foods[i], cuisines[i], ratings[i]);
                fMap.put(foods[i], food);
                cfMap.computeIfAbsent(cuisines[i], v -> new TreeSet<Food>()).add(food);
            }
        }

        public void changeRating(String foodName, int newRating) {
            var oldFood = fMap.get(foodName);
            var newFood = new Food(foodName, oldFood.cuisine, newRating);
            fMap.put(foodName, newFood);                // 覆盖旧数据
            cfMap.get(oldFood.cuisine).remove(oldFood); // 有序集合移除旧数据
            cfMap.get(oldFood.cuisine).add(newFood);
        }

        public String highestRated(String cuisine) {
            return cfMap.get(cuisine).first().name;     // 返回有序集合的第一个
        }

        class Food implements Comparable<Food>{
            String name;
            String cuisine;
            Integer rating;

            public Food(String name, String cuisine, Integer rating) {
                this.name = name;
                this.cuisine = cuisine;
                this.rating = rating;
            }

            @Override
            public int compareTo(Food o) {
                return this.rating.equals(o.rating) ?
                        this.name.compareTo(o.name) : o.rating - this.rating;
            }
        }
    }

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
}
