package zjhl.wxf.openeyes.bean;

import java.util.List;

/**
 * Created by Weixf
 * Date on 2017/3/2.
 * Describe 精选界面的数据源
 */

public class ChoicenessBean extends BaseBean{
    /**
     * itemList : null
     * count : 18
     * total : 0
     * nextPageUrl : http://baobab.kaiyanapp.com/api/v4/tabs/selected?date=1488330000000&num=2&page=2
     * date : 1488416400000
     * nextPublishTime : 1488459600000
     * dialog : null
     */

    public List<Object> itemList;
    private int count;
    private int total;
    private String nextPageUrl;
    private long date;
    private long nextPublishTime;
    private Object dialog;

    public List<Object> getItemList() {
        return itemList;
    }

    public void setItemList(List<Object> itemList) {
        this.itemList = itemList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getNextPublishTime() {
        return nextPublishTime;
    }

    public void setNextPublishTime(long nextPublishTime) {
        this.nextPublishTime = nextPublishTime;
    }

    public Object getDialog() {
        return dialog;
    }

    public void setDialog(Object dialog) {
        this.dialog = dialog;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "itemList=" + itemList +
                ", count=" + count +
                ", total=" + total +
                ", nextPageUrl='" + nextPageUrl + '\'' +
                ", date=" + date +
                ", nextPublishTime=" + nextPublishTime +
                ", dialog=" + dialog +
                '}';
    }

}
