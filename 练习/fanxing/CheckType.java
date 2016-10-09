package fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjh on 16-7-22.
 */

//自定义一个strList集合类，使用组合的方式来复用ArrayList类
    class  StrList{
    private List strList = new ArrayList();
    public boolean add(String ele){
        return strList.add(ele);
    }

    public String get(int index){
        return (String)strList.get(index);
    }

    public int size(){
        return strList.size();
    }
}
public class CheckType {
    public static void main(String[] args){
        StrList strList = new StrList();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        System.out.println(strList);
        for(int i=0; i<strList.size(); i++){
            String str = strList.get(i);
        }
    }
}
