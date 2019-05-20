package com.xzb.comparator;

import java.util.Comparator;
import com.xzb.pojo.Lost;
//新品比较器，将创建日期晚的放在前面
public class LostDateComparator implements Comparator<Lost>{

   @Override
   public int compare(Lost l1, Lost l2) {
       return l2.getPickDate().compareTo(l1.getPickDate());
   }

}