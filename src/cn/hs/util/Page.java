package cn.hs.util;

import java.util.ArrayList;
import java.util.List;

// 封装的是分页相关信息
public class Page<T> {
    private int currentPage;            // 访问的页码
    private int pageNum;                // 每页展示的条数
    private int count;                  // 数据总条数
    private int pageCount;              // 总页数
    private int startIndex;             // 开始下标
    private List<T> list = new ArrayList<>(); // 查询的数据集合

    public Page(int currentPage, int pageNum, int count) {
        this.pageNum = pageNum;
        this.count = count;
        // 计算总页数
        this.pageCount = (this.count%this.pageNum==0)?(this.count/this.pageNum):(this.count/this.pageNum+1);
        //判断currentPage的合法性
        if(currentPage>this.pageCount){
            currentPage=this.pageCount;
        }
        if(currentPage<=0){
            currentPage=1;
        }
        this.currentPage=currentPage;
        // 计算开始下标
        this.startIndex = (this.currentPage-1)*this.pageNum;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
