package zjhl.wxf.openeyes.bean;

import java.util.List;

/**
 * Created by Weixf
 * Date on 2017/3/2.
 * Describe 精选部分type为video的实体类
 */

public class ChoicenessVideoBean extends BaseBean {
    @Override
    public String toString() {
        return "ChoicenessVideoBean{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * type : video
     * data : {"dataType":"VideoBeanForClient","id":15160,"title":"特条丨「地平线：零点黎明」真人宣传片","description":"「Horizon Zero Dawn」推出最新真人版宣传片，由日本女演员山本舞香出演。文明的崩坏 1000 年后的地球科技与原始感并存，险象环生，人生艰难，有人玩成「古墓丽影」，有人玩成「辐射」\u2026\u2026","provider":{"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"},"category":"游戏","author":{"id":325,"icon":"http://img.kaiyanapp.com/77d8ef330067c3f9577fd90e7c9b244f.jpeg","name":"索尼 PlayStation","description":"第一时间为你提供最新的 PlayStation 游戏预告、幕后视频","link":"https://www.youtube.com/user/PlayStation/","latestReleaseTime":1488424707000,"videoNum":54,"adTrack":null,"follow":{"itemType":"author","itemId":325,"followed":false},"authorType":"MOCK"},"cover":{"feed":"http://img.kaiyanapp.com/982c1b1efea09e49d9aeffd8adecc25f.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/982c1b1efea09e49d9aeffd8adecc25f.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/f3ea9d5b1404c6a51f5460b0f998146f.jpeg?imageMogr2/quality/60/format/jpg","sharing":null},"playUrl":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=default&source=ucloud","duration":87,"webUrl":{"raw":"http://www.eyepetizer.net/detail.html?vid=15160","forWeibo":"http://wandou.im/3m79vl"},"releaseTime":1488424707000,"playInfo":[{"height":270,"width":480,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=low&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=low&source=qcloud"}],"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=low&source=ucloud"},{"height":480,"width":854,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=normal&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=normal&source=qcloud"}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=normal&source=ucloud"},{"height":720,"width":1280,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=high&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=high&source=qcloud"}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=high&source=ucloud"}],"consumption":{"collectionCount":119,"shareCount":218,"replyCount":4},"campaign":null,"waterMarks":null,"adTrack":null,"tags":[{"id":30,"name":"游戏","actionUrl":"eyepetizer://tag/30/?title=%E6%B8%B8%E6%88%8F","adTrack":null},{"id":384,"name":"日本广告","actionUrl":"eyepetizer://tag/384/?title=%E6%97%A5%E6%9C%AC%E5%B9%BF%E5%91%8A","adTrack":null},{"id":122,"name":"科幻","actionUrl":"eyepetizer://tag/122/?title=%E7%A7%91%E5%B9%BB","adTrack":null},{"id":118,"name":"虐心","actionUrl":"eyepetizer://tag/118/?title=%E8%99%90%E5%BF%83","adTrack":null},{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null}],"type":"NORMAL","idx":0,"shareAdTrack":null,"favoriteAdTrack":null,"webAdTrack":null,"date":1488416400000,"promotion":null,"label":null,"collected":false,"played":false}
     */

    private String type;
    /**
     * dataType : VideoBeanForClient
     * id : 15160
     * title : 特条丨「地平线：零点黎明」真人宣传片
     * description : 「Horizon Zero Dawn」推出最新真人版宣传片，由日本女演员山本舞香出演。文明的崩坏 1000 年后的地球科技与原始感并存，险象环生，人生艰难，有人玩成「古墓丽影」，有人玩成「辐射」……
     * provider : {"name":"YouTube","alias":"youtube","icon":"http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"}
     * category : 游戏
     * author : {"id":325,"icon":"http://img.kaiyanapp.com/77d8ef330067c3f9577fd90e7c9b244f.jpeg","name":"索尼 PlayStation","description":"第一时间为你提供最新的 PlayStation 游戏预告、幕后视频","link":"https://www.youtube.com/user/PlayStation/","latestReleaseTime":1488424707000,"videoNum":54,"adTrack":null,"follow":{"itemType":"author","itemId":325,"followed":false},"authorType":"MOCK"}
     * cover : {"feed":"http://img.kaiyanapp.com/982c1b1efea09e49d9aeffd8adecc25f.jpeg?imageMogr2/quality/60/format/jpg","detail":"http://img.kaiyanapp.com/982c1b1efea09e49d9aeffd8adecc25f.jpeg?imageMogr2/quality/60/format/jpg","blurred":"http://img.kaiyanapp.com/f3ea9d5b1404c6a51f5460b0f998146f.jpeg?imageMogr2/quality/60/format/jpg","sharing":null}
     * playUrl : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=default&source=ucloud
     * duration : 87
     * webUrl : {"raw":"http://www.eyepetizer.net/detail.html?vid=15160","forWeibo":"http://wandou.im/3m79vl"}
     * releaseTime : 1488424707000
     * playInfo : [{"height":270,"width":480,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=low&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=low&source=qcloud"}],"name":"流畅","type":"low","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=low&source=ucloud"},{"height":480,"width":854,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=normal&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=normal&source=qcloud"}],"name":"标清","type":"normal","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=normal&source=ucloud"},{"height":720,"width":1280,"urlList":[{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=high&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=high&source=qcloud"}],"name":"高清","type":"high","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=high&source=ucloud"}]
     * consumption : {"collectionCount":119,"shareCount":218,"replyCount":4}
     * campaign : null
     * waterMarks : null
     * adTrack : null
     * tags : [{"id":30,"name":"游戏","actionUrl":"eyepetizer://tag/30/?title=%E6%B8%B8%E6%88%8F","adTrack":null},{"id":384,"name":"日本广告","actionUrl":"eyepetizer://tag/384/?title=%E6%97%A5%E6%9C%AC%E5%B9%BF%E5%91%8A","adTrack":null},{"id":122,"name":"科幻","actionUrl":"eyepetizer://tag/122/?title=%E7%A7%91%E5%B9%BB","adTrack":null},{"id":118,"name":"虐心","actionUrl":"eyepetizer://tag/118/?title=%E8%99%90%E5%BF%83","adTrack":null},{"id":16,"name":"广告","actionUrl":"eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A","adTrack":null}]
     * type : NORMAL
     * idx : 0
     * shareAdTrack : null
     * favoriteAdTrack : null
     * webAdTrack : null
     * date : 1488416400000
     * promotion : null
     * label : null
     * collected : false
     * played : false
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
        @Override
        public String toString() {
            return "DataBean{" +
                    "dataType='" + dataType + '\'' +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", provider=" + provider +
                    ", category='" + category + '\'' +
                    ", author=" + author +
                    ", cover=" + cover +
                    ", playUrl='" + playUrl + '\'' +
                    ", duration=" + duration +
                    ", webUrl=" + webUrl +
                    ", releaseTime=" + releaseTime +
                    ", consumption=" + consumption +
                    ", campaign=" + campaign +
                    ", waterMarks=" + waterMarks +
                    ", adTrack=" + adTrack +
                    ", type='" + type + '\'' +
                    ", idx=" + idx +
                    ", shareAdTrack=" + shareAdTrack +
                    ", favoriteAdTrack=" + favoriteAdTrack +
                    ", webAdTrack=" + webAdTrack +
                    ", date=" + date +
                    ", promotion=" + promotion +
                    ", label=" + label +
                    ", collected=" + collected +
                    ", played=" + played +
                    ", playInfo=" + playInfo +
                    ", tags=" + tags +
                    '}';
        }
        private String dataType;
        private int id;
        private String title;
        private String description;
        /**
         * name : YouTube
         * alias : youtube
         * icon : http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
         */

        private ProviderBean provider;
        private String category;
        /**
         * id : 325
         * icon : http://img.kaiyanapp.com/77d8ef330067c3f9577fd90e7c9b244f.jpeg
         * name : 索尼 PlayStation
         * description : 第一时间为你提供最新的 PlayStation 游戏预告、幕后视频
         * link : https://www.youtube.com/user/PlayStation/
         * latestReleaseTime : 1488424707000
         * videoNum : 54
         * adTrack : null
         * follow : {"itemType":"author","itemId":325,"followed":false}
         * authorType : MOCK
         */

        private AuthorBean author;
        /**
         * feed : http://img.kaiyanapp.com/982c1b1efea09e49d9aeffd8adecc25f.jpeg?imageMogr2/quality/60/format/jpg
         * detail : http://img.kaiyanapp.com/982c1b1efea09e49d9aeffd8adecc25f.jpeg?imageMogr2/quality/60/format/jpg
         * blurred : http://img.kaiyanapp.com/f3ea9d5b1404c6a51f5460b0f998146f.jpeg?imageMogr2/quality/60/format/jpg
         * sharing : null
         */

        private CoverBean cover;
        private String playUrl;
        private int duration;
        /**
         * raw : http://www.eyepetizer.net/detail.html?vid=15160
         * forWeibo : http://wandou.im/3m79vl
         */

        private WebUrlBean webUrl;
        private long releaseTime;
        /**
         * collectionCount : 119
         * shareCount : 218
         * replyCount : 4
         */

        private ConsumptionBean consumption;
        private Object campaign;
        private Object waterMarks;
        private Object adTrack;
        private String type;
        private int idx;
        private Object shareAdTrack;
        private Object favoriteAdTrack;
        private Object webAdTrack;
        private long date;
        private Object promotion;
        private Object label;
        private boolean collected;
        private boolean played;
        /**
         * height : 270
         * width : 480
         * urlList : [{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=low&source=ucloud"},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=low&source=qcloud"}]
         * name : 流畅
         * type : low
         * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=low&source=ucloud
         */

        private List<PlayInfoBean> playInfo;
        /**
         * id : 30
         * name : 游戏
         * actionUrl : eyepetizer://tag/30/?title=%E6%B8%B8%E6%88%8F
         * adTrack : null
         */

        private List<TagsBean> tags;

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

        public ProviderBean getProvider() {
            return provider;
        }

        public void setProvider(ProviderBean provider) {
            this.provider = provider;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public CoverBean getCover() {
            return cover;
        }

        public void setCover(CoverBean cover) {
            this.cover = cover;
        }

        public String getPlayUrl() {
            return playUrl;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public WebUrlBean getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(WebUrlBean webUrl) {
            this.webUrl = webUrl;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public ConsumptionBean getConsumption() {
            return consumption;
        }

        public void setConsumption(ConsumptionBean consumption) {
            this.consumption = consumption;
        }

        public Object getCampaign() {
            return campaign;
        }

        public void setCampaign(Object campaign) {
            this.campaign = campaign;
        }

        public Object getWaterMarks() {
            return waterMarks;
        }

        public void setWaterMarks(Object waterMarks) {
            this.waterMarks = waterMarks;
        }

        public Object getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(Object adTrack) {
            this.adTrack = adTrack;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public Object getShareAdTrack() {
            return shareAdTrack;
        }

        public void setShareAdTrack(Object shareAdTrack) {
            this.shareAdTrack = shareAdTrack;
        }

        public Object getFavoriteAdTrack() {
            return favoriteAdTrack;
        }

        public void setFavoriteAdTrack(Object favoriteAdTrack) {
            this.favoriteAdTrack = favoriteAdTrack;
        }

        public Object getWebAdTrack() {
            return webAdTrack;
        }

        public void setWebAdTrack(Object webAdTrack) {
            this.webAdTrack = webAdTrack;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public Object getPromotion() {
            return promotion;
        }

        public void setPromotion(Object promotion) {
            this.promotion = promotion;
        }

        public Object getLabel() {
            return label;
        }

        public void setLabel(Object label) {
            this.label = label;
        }

        public boolean isCollected() {
            return collected;
        }

        public void setCollected(boolean collected) {
            this.collected = collected;
        }

        public boolean isPlayed() {
            return played;
        }

        public void setPlayed(boolean played) {
            this.played = played;
        }

        public List<PlayInfoBean> getPlayInfo() {
            return playInfo;
        }

        public void setPlayInfo(List<PlayInfoBean> playInfo) {
            this.playInfo = playInfo;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class ProviderBean {
            private String name;
            private String alias;
            private String icon;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

        }

        public static class AuthorBean {
            private int id;
            private String icon;
            private String name;
            private String description;
            private String link;
            private long latestReleaseTime;
            private int videoNum;
            private Object adTrack;
            /**
             * itemType : author
             * itemId : 325
             * followed : false
             */

            private FollowBean follow;
            private String authorType;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public long getLatestReleaseTime() {
                return latestReleaseTime;
            }

            public void setLatestReleaseTime(long latestReleaseTime) {
                this.latestReleaseTime = latestReleaseTime;
            }

            public int getVideoNum() {
                return videoNum;
            }

            public void setVideoNum(int videoNum) {
                this.videoNum = videoNum;
            }

            public Object getAdTrack() {
                return adTrack;
            }

            public void setAdTrack(Object adTrack) {
                this.adTrack = adTrack;
            }

            public FollowBean getFollow() {
                return follow;
            }

            public void setFollow(FollowBean follow) {
                this.follow = follow;
            }

            public String getAuthorType() {
                return authorType;
            }

            public void setAuthorType(String authorType) {
                this.authorType = authorType;
            }

            public static class FollowBean {
                private String itemType;
                private int itemId;
                private boolean followed;

                public String getItemType() {
                    return itemType;
                }

                public void setItemType(String itemType) {
                    this.itemType = itemType;
                }

                public int getItemId() {
                    return itemId;
                }

                public void setItemId(int itemId) {
                    this.itemId = itemId;
                }

                public boolean isFollowed() {
                    return followed;
                }

                public void setFollowed(boolean followed) {
                    this.followed = followed;
                }
            }
        }

        public static class CoverBean {
            private String feed;
            private String detail;
            private String blurred;
            private Object sharing;

            public String getFeed() {
                return feed;
            }

            public void setFeed(String feed) {
                this.feed = feed;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getBlurred() {
                return blurred;
            }

            public void setBlurred(String blurred) {
                this.blurred = blurred;
            }

            public Object getSharing() {
                return sharing;
            }

            public void setSharing(Object sharing) {
                this.sharing = sharing;
            }
        }

        public static class WebUrlBean {
            private String raw;
            private String forWeibo;

            public String getRaw() {
                return raw;
            }

            public void setRaw(String raw) {
                this.raw = raw;
            }

            public String getForWeibo() {
                return forWeibo;
            }

            public void setForWeibo(String forWeibo) {
                this.forWeibo = forWeibo;
            }
        }

        public static class ConsumptionBean {
            private int collectionCount;
            private int shareCount;
            private int replyCount;

            public int getCollectionCount() {
                return collectionCount;
            }

            public void setCollectionCount(int collectionCount) {
                this.collectionCount = collectionCount;
            }

            public int getShareCount() {
                return shareCount;
            }

            public void setShareCount(int shareCount) {
                this.shareCount = shareCount;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }
        }

        public static class PlayInfoBean {
            private int height;
            private int width;
            private String name;
            private String type;
            private String url;
            /**
             * name : ucloud
             * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=15160&editionType=low&source=ucloud
             */

            private List<UrlListBean> urlList;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<UrlListBean> getUrlList() {
                return urlList;
            }

            public void setUrlList(List<UrlListBean> urlList) {
                this.urlList = urlList;
            }

            public static class UrlListBean {
                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class TagsBean {
            private int id;
            private String name;
            private String actionUrl;
            private Object adTrack;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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
}
