package zjhl.wxf.openeyes.bean;

import java.util.List;

/**
 * Created by Weixf
 * Date on 2017/3/10.
 * Describe
 */

public class ChoicenessSquareCardBean extends BaseBean{
    @Override
    public String toString() {
        return "ChoicenessSquareCardBean{" +
                "type='" + type + '\'' +
                ", data=" + data +
                ", tag=" + tag +
                '}';
    }

    /**
     * type : squareCardCollection
     * data : {"dataType":"ItemCollection","header":{"id":1,"title":"热门分类","font":"bold","cover":null,"label":null,"actionUrl":"eyepetizer://categories/all"},"itemList":[{"type":"squareCard","data":{"dataType":"SquareCard","id":24,"title":"#时尚","image":"http://img.kaiyanapp.com/22192a40de238fe853b992ed57f1f098.jpeg","actionUrl":"eyepetizer://category/24/?title=%E6%97%B6%E5%B0%9A","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":32,"title":"#科普","image":"http://img.kaiyanapp.com/0117b9108c7cff43700db8af5e24f2bf.jpeg","actionUrl":"eyepetizer://category/32/?title=%E7%A7%91%E6%99%AE","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":14,"title":"#广告","image":"http://img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg","actionUrl":"eyepetizer://category/14/?title=%E5%B9%BF%E5%91%8A","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":8,"title":"#预告","image":"http://img.kaiyanapp.com/003829087e85ce7310b2210d9575ce67.jpeg","actionUrl":"eyepetizer://category/8/?title=%E9%A2%84%E5%91%8A","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":30,"title":"#游戏","image":"http://img.kaiyanapp.com/2b7ac9d21ca06df7e39e80a3799a3fb6.jpeg","actionUrl":"eyepetizer://category/30/?title=%E6%B8%B8%E6%88%8F","shade":true,"adTrack":null},"tag":null},{"type":"actionCard","data":{"dataType":"ActionCard","id":0,"text":"查看全部","actionUrl":"eyepetizer://categories/all","adTrack":null},"tag":null}],"count":6,"adTrack":null}
     * tag : null
     */

    private String type;
    /**
     * dataType : ItemCollection
     * header : {"id":1,"title":"热门分类","font":"bold","cover":null,"label":null,"actionUrl":"eyepetizer://categories/all"}
     * itemList : [{"type":"squareCard","data":{"dataType":"SquareCard","id":24,"title":"#时尚","image":"http://img.kaiyanapp.com/22192a40de238fe853b992ed57f1f098.jpeg","actionUrl":"eyepetizer://category/24/?title=%E6%97%B6%E5%B0%9A","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":32,"title":"#科普","image":"http://img.kaiyanapp.com/0117b9108c7cff43700db8af5e24f2bf.jpeg","actionUrl":"eyepetizer://category/32/?title=%E7%A7%91%E6%99%AE","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":14,"title":"#广告","image":"http://img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg","actionUrl":"eyepetizer://category/14/?title=%E5%B9%BF%E5%91%8A","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":8,"title":"#预告","image":"http://img.kaiyanapp.com/003829087e85ce7310b2210d9575ce67.jpeg","actionUrl":"eyepetizer://category/8/?title=%E9%A2%84%E5%91%8A","shade":true,"adTrack":null},"tag":null},{"type":"squareCard","data":{"dataType":"SquareCard","id":30,"title":"#游戏","image":"http://img.kaiyanapp.com/2b7ac9d21ca06df7e39e80a3799a3fb6.jpeg","actionUrl":"eyepetizer://category/30/?title=%E6%B8%B8%E6%88%8F","shade":true,"adTrack":null},"tag":null},{"type":"actionCard","data":{"dataType":"ActionCard","id":0,"text":"查看全部","actionUrl":"eyepetizer://categories/all","adTrack":null},"tag":null}]
     * count : 6
     * adTrack : null
     */

    private DataBean data;
    private Object tag;

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

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public static class DataBean {
        private String dataType;
        /**
         * id : 1
         * title : 热门分类
         * font : bold
         * cover : null
         * label : null
         * actionUrl : eyepetizer://categories/all
         */

        private HeaderBean header;
        private int count;
        private Object adTrack;
        /**
         * type : squareCard
         * data : {"dataType":"SquareCard","id":24,"title":"#时尚","image":"http://img.kaiyanapp.com/22192a40de238fe853b992ed57f1f098.jpeg","actionUrl":"eyepetizer://category/24/?title=%E6%97%B6%E5%B0%9A","shade":true,"adTrack":null}
         * tag : null
         */

        private List<ItemListBean> itemList;

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        public static class HeaderBean {
            private int id;
            private String title;
            private String font;
            private Object cover;
            private Object label;
            private String actionUrl;

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

            public String getFont() {
                return font;
            }

            public void setFont(String font) {
                this.font = font;
            }

            public Object getCover() {
                return cover;
            }

            public void setCover(Object cover) {
                this.cover = cover;
            }

            public Object getLabel() {
                return label;
            }

            public void setLabel(Object label) {
                this.label = label;
            }

            public String getActionUrl() {
                return actionUrl;
            }

            public void setActionUrl(String actionUrl) {
                this.actionUrl = actionUrl;
            }
        }

        public static class ItemListBean {
            private String type;
            /**
             * dataType : SquareCard
             * id : 24
             * title : #时尚
             * image : http://img.kaiyanapp.com/22192a40de238fe853b992ed57f1f098.jpeg
             * actionUrl : eyepetizer://category/24/?title=%E6%97%B6%E5%B0%9A
             * shade : true
             * adTrack : null
             */

            private ItemDataBean data;
            private Object tag;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public ItemDataBean getData() {
                return data;
            }

            public void setData(ItemDataBean data) {
                this.data = data;
            }

            public Object getTag() {
                return tag;
            }

            public void setTag(Object tag) {
                this.tag = tag;
            }

            public static class ItemDataBean {
                private String dataType;
                private int id;
                private String title;
                private String image;
                private String actionUrl;
                private boolean shade;
                private Object adTrack;

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

                public boolean isShade() {
                    return shade;
                }

                public void setShade(boolean shade) {
                    this.shade = shade;
                }

                public Object getAdTrack() {
                    return adTrack;
                }

                public void setAdTrack(Object adTrack) {
                    this.adTrack = adTrack;
                }
            }
        }
    }
}
