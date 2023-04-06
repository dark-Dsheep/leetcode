package Design;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class LC_2353 {

//    2353. 设计食物评分系统
    class FoodRatings {

        HashMap<String, Food> fMap = new HashMap<>();                // 食物名称 食物类
        HashMap<String, PriorityQueue<Food>> cfMap = new HashMap<>(); // 烹饪方式 食物队列


        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int n = foods.length;
            for (int i = 0; i < n; i++) {
                var food = new Food(foods[i], cuisines[i], ratings[i]);
                var pq = cfMap.computeIfAbsent(cuisines[i], v -> new PriorityQueue<Food>(((o1, o2) -> cmp(o1, o2))));
                pq.offer(food);
                cfMap.put(cuisines[i], pq);
                fMap.put(foods[i], food);
            }
        }

        public void changeRating(String foodName, int newRating) {
            var food = fMap.get(foodName);
            food.delete = true;
            var newFood = new Food(food.name, food.cuisine, newRating);
            fMap.put(foodName, newFood);
            cfMap.get(food.cuisine).add(newFood);
        }

        public String highestRated(String cuisine) {
            // 返回 堆顶元素
            var pq = cfMap.get(cuisine);
            process(pq);    //
            return pq.peek().name;
        }
        // 处理队列中标记为删除的食物
        void process(PriorityQueue<Food> pq) {
            while (pq.size() > 0 && pq.peek().delete) {
                pq.remove();
            }
        }

        int cmp(Food a, Food b) {
            return a.rating.equals(b.rating) ? a.name.compareTo(b.name) : b.rating - a.rating;
        }

        class Food implements Comparable<Food>{
            String name;
            String cuisine;
            Integer rating;
            boolean delete; // 删除标记

            public Food(String name, String cuisine, Integer rating) {
                this.name = name;
                this.cuisine = cuisine;
                this.rating = rating;
                this.delete = false;
            }

            @Override
            public int compareTo(Food o) {
                return this.rating.equals(o.rating) ?
                        this.name.compareTo(o.name) : o.rating - this.rating;
            }
        }
    }

    // 有序集合
    class FoodRatings2 {

        HashMap<String, Food> fMap = new HashMap<>();            // 食物名称 食物类
        HashMap<String, TreeSet<Food>> cfMap = new HashMap<>();  // 烹饪方式 食物有序集合

        public FoodRatings2(String[] foods, String[] cuisines, int[] ratings) {
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

    public static void main(String[] args) {

    }
}
