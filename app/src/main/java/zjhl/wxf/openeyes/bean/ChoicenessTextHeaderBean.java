package zjhl.wxf.openeyes.bean;

/**
 * Created by Weixf
 * Date on 2017/3/2.
 * Describe
 */

public class ChoicenessTextHeaderBean extends BaseBean {
    @Override
    public String toString() {
        return "ChoicenessTextHeaderBean{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * type : textHeader
     * data : {"dataType":"TextHeader","text":"- Mar. 01, Supper -","font":"lobster","adTrack":null}
     */

    private String type;
    /**
     * dataType : TextHeader
     * text : - Mar. 01, Supper -
     * font : lobster
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

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }
    }
}
