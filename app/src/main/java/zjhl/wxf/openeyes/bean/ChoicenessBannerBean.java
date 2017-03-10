package zjhl.wxf.openeyes.bean;

/**
 * Created by Weixf
 * Date on 2017/3/10.
 * Describe
 */

public class ChoicenessBannerBean extends BaseBean{
    @Override
    public String toString() {
        return "ChoicenessBannerBean{" +
                "type='" + type + '\'' +
                ", data=" + data +
                ", tag='" + tag + '\'' +
                '}';
    }

    /**
     * type : banner2
     * data : {"dataType":"Banner","id":308,"title":"","description":"","image":"http://img.kaiyanapp.com/fc652727a588c237b5d7df0c3e710d3e.jpeg?imageMogr2/quality/60/format/jpg","actionUrl":"eyepetizer://webview/?title=%E5%BC%80%E7%9C%BC%E8%B0%83%E7%A0%94&url=https%3A%2F%2Fwww.diaochapai.com%2Fsurvey2501704%3Fext%3D0_","adTrack":null,"shade":false,"label":{"text":null,"card":null,"detail":null}}
     * tag : 2
     */

    private String type;
    /**
     * dataType : Banner
     * id : 308
     * title :
     * description :
     * image : http://img.kaiyanapp.com/fc652727a588c237b5d7df0c3e710d3e.jpeg?imageMogr2/quality/60/format/jpg
     * actionUrl : eyepetizer://webview/?title=%E5%BC%80%E7%9C%BC%E8%B0%83%E7%A0%94&url=https%3A%2F%2Fwww.diaochapai.com%2Fsurvey2501704%3Fext%3D0_
     * adTrack : null
     * shade : false
     * label : {"text":null,"card":null,"detail":null}
     */

    private DataBean data;
    private String tag;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "dataType='" + dataType + '\'' +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", image='" + image + '\'' +
                    ", actionUrl='" + actionUrl + '\'' +
                    ", adTrack=" + adTrack +
                    ", shade=" + shade +
                    ", label=" + label +
                    '}';
        }

        private String dataType;
        private int id;
        private String title;
        private String description;
        private String image;
        private String actionUrl;
        private Object adTrack;
        private boolean shade;
        /**
         * text : null
         * card : null
         * detail : null
         */

        private LabelBean label;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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

        public boolean isShade() {
            return shade;
        }

        public void setShade(boolean shade) {
            this.shade = shade;
        }

        public LabelBean getLabel() {
            return label;
        }

        public void setLabel(LabelBean label) {
            this.label = label;
        }

        public static class LabelBean {
            private Object text;
            private Object card;
            private Object detail;

            public Object getText() {
                return text;
            }

            public void setText(Object text) {
                this.text = text;
            }

            public Object getCard() {
                return card;
            }

            public void setCard(Object card) {
                this.card = card;
            }

            public Object getDetail() {
                return detail;
            }

            public void setDetail(Object detail) {
                this.detail = detail;
            }
        }
    }
}
