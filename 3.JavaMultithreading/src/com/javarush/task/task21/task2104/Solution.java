package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        //Метод equals должен проверять является ли переданный объект объектом класса Solution.
        //if (o.getClass()==solution.getClass()) return true; <- no validation
        if (!(o instanceof Solution)) return false;
        return Objects.equals(first, solution.first) &&
                Objects.equals(last, solution.last);
    }

    /*public boolean equals(Solution n) {

        return n.first.equals(first) && n.last.equals(last);
    }*/

    public int hashCode() {
        if (first!=null&last!=null)
            return 31 * first.hashCode() + last.hashCode();
        else return 0;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        /*s.add(new Solution(null, null));
        System.out.println(s.contains(new Solution(null, null)));*/
    }
}
