package zjhl.wxf.openeyes.bean;

/**
 * Created by Weixf
 * Date on 2017/3/2.
 * Describe
 */

public class ChoicenessTextFooterBean extends BaseBean{
    @Override
    public String toString() {
        return "ChoicenessTextFooterBean{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * type : textFooter
     * data : {"dataType":"TextFooter","text":"查看往期编辑精选","font":"normal","actionUrl":"eyepetizer://feed?issueIndex=1","adTrack":null}
     */

    private String type;
    /**
     * dataType : TextFooter
     * text : 查看往期编辑精选
     * font : normal
     * actionUrl : eyepetizer://feed?issueIndex=1
     * adTrack : null
     */

    private DataBean data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String dataType;
        private String text;
        private String font;
        private String actionUrl;
        private Object adTrack;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getFont() {
            return font;
        }

        public void setFont(String font) {
            this.font = font;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }
    }
}
