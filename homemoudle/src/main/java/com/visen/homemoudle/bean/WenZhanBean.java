package com.visen.homemoudle.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * @作者 严益云
 * @创建日期 2020/12/1
 * 类名 WenZhanBean.java
 */
public class WenZhanBean extends BaseObservable {

    /**
     * getstate : ok
     * action : cgmw_all_editortj
     * pageindex : 1
     * pagesize : 30
     * pagecount : 10
     * rows : 300
     * lists : 30
     * time : 2019-06-17 15:41
     * list : [{"id":"1033387","title":"送你一生的温暖","summary":"她并非凡俗女子，相反，相当优秀，追求者云集。而她，排开众人，毅然跟了他。当时，他一无所有，在一家工厂打工，收入不够解决两人温饱。为了他，她失去亲人，丢了工作。他","classname":"爱情故事","userid":"235901","author":"花落随风","headurl":"http://qzapp.qlogo.cn/qzapp/100448328/26CB8AD94385873871F12A6AB651FBC3/100","sd":"235901","xw":"二阶初级","hits":"22","goods":0,"bads":0,"dpcount":2,"dpfen":"9.9","addtime":"2019-06-16 15:05","sht":"06-16"},{"id":"1033377","title":"扶贫路上携手共牵","summary":"\u2014\u2014走访谢流香　一走进办公室，村里的计生专干张明会就迫不及待的跟我说，\u201c婶娘，我昨天和啊娘到村里给慢性病患者进行上门服务检查，谢流香她屋两个都有高血压，但是谢流","classname":"心情文章","userid":"219853","author":"英鑫媛子","headurl":"http://qzapp.qlogo.cn/qzapp/100448328/D8AA1DCAC990A82943B28F1D3F203C7A/100","sd":"219853","xw":"神王中级","hits":"18","goods":0,"bads":0,"dpcount":4,"dpfen":"9.2","addtime":"2019-06-16 08:53","sht":"06-16"},{"id":"1033372","title":"消失的液化罐","summary":"消失的液化罐　（文/占武）　　上世纪80年代，我结婚的时候住西地在筒子楼，楼房的使用面积不到30平米，室内有厨房和厕所，里面一间大屋是起居室，　爱人每天在转身都","classname":"心情文章","userid":"225292","author":"占武","headurl":"","sd":"lizhanw","xw":"仙阶中级","hits":"21","goods":0,"bads":0,"dpcount":2,"dpfen":"8.7","addtime":"2019-06-15 22:11","sht":"06-16"},{"id":"1033386","title":"小小插曲","summary":"\u201c啪！\u201d一声清脆的掌声，惊呆了教室里所有的同学，大家不约而同地望着教室后门的两个女生，一个是本班的丽，一个是隔壁班的娜。两个人都涨红了脸，扭成一团，此刻，却谁也","classname":"校园文章","userid":"214189","author":"乾坤尔萨城","headurl":"http://www.duwenz.com/space/headimages/214189.jpg","sd":"214189","xw":"天阶圣者","hits":"18","goods":0,"bads":0,"dpcount":4,"dpfen":"8.7","addtime":"2019-06-16 14:24","sht":"06-16"},{"id":"1033361","title":"夏荷吐香，氤氲流年","summary":"走向夏月，倚袅袅荷香，擎半壶思绪，斟一盏惦念与遥望。常常，不自觉地想，生命就像笔端精心画出的美丽弧线，在生活的一纸素娟上，明媚而耀眼；也像熏风，不经意地剥开了粉","classname":"抒情散文","userid":"134295","author":"*闲坐等清风*","headurl":"http://www.duwenz.com/space/headimages/134295.jpg","sd":"134295","xw":"天阶圣者","hits":"37","goods":0,"bads":0,"dpcount":3,"dpfen":"9.9","addtime":"2019-06-14 20:39","sht":"06-15"},{"id":"1033369","title":"玉陨","summary":"\u201c枫，你是不是爱上我了呀？\u201d叶儿嬉皮笑脸地在枫面前做了一个鬼脸，嘟起的嘴巴在离枫还有一毫米的时候迅速撤离。　\u201c去去去，谁会爱上你，好比活人恋上鬼！\u201d枫满脸的不屑","classname":"伤感文章","userid":"214189","author":"乾坤尔萨城","headurl":"http://www.duwenz.com/space/headimages/214189.jpg","sd":"214189","xw":"天阶圣者","hits":"28","goods":0,"bads":0,"dpcount":2,"dpfen":"9.4","addtime":"2019-06-15 19:44","sht":"06-15"},{"id":"1033358","title":"惜日榆杨柳","summary":"作者/孙喜臣　片筐，还在用着，我也在编着。去年初冬，我割来一些杨树条，又在邻居家园子边、割来了榆树条，我一次编了四只混条的片筐，二姑娘家、三姑娘家，各给她们一只","classname":"心情文章","userid":"204632","author":"研语涵","headurl":"http://www.duwenz.com/space/headimages/204632.jpg","sd":"204632","xw":"四阶初级","hits":"18","goods":0,"bads":0,"dpcount":4,"dpfen":"9.2","addtime":"2019-06-14 20:01","sht":"06-15"},{"id":"1033363","title":"幽虚.小故事之\u201c强势美人\u201d","summary":"眼前的人儿，身材高大丰满，曲线有致，黑色微卷的长发漫过腰际，浅棕色的皮肤闪耀着健康的光泽；鹅蛋形的脸庞，细黑的直眉，小巧挺直的鼻子，珊瑚红色丰润的嘴唇，明媚的大","classname":"爱情故事","userid":"233703","author":"源澈","headurl":"http://www.duwenz.com/space/headimages/233703.jpg","sd":"233703","xw":"三阶初级","hits":"27","goods":0,"bads":0,"dpcount":3,"dpfen":"9.2","addtime":"2019-06-14 21:23","sht":"06-15"},{"id":"1033360","title":"暴雨淋了一夜的小男孩","summary":"一个两岁的小男孩，家有一长姐。他的奶奶家住在河边，看河口。门推开一两米就是河流。某天，小男孩在奶奶家睡觉，他父亲也躺在里面睡觉，姐姐也在屋内。他的母亲在打麻将，","classname":"伤感文章","userid":"185778","author":"许方元","headurl":"http://www.duwenz.com/space/headimages/185778.jpg","sd":"185778","xw":"五阶巅峰","hits":"24","goods":0,"bads":0,"dpcount":4,"dpfen":"8","addtime":"2019-06-14 20:20","sht":"06-15"},{"id":"1033353","title":"再回首，以纵深的方式审视人生","summary":"从枯枝吐绿、万紫千红的春，走到裙角飞扬、清荷溢香的夏。从飒风萧瑟、层林尽染的秋，走到白雪纷飞、寒梅独放的冬。每一年，每一年，季节都是如此的轮回，就在这样轮回的中","classname":"抒情散文","userid":"227771","author":"北斗","headurl":"http://qzapp.qlogo.cn/qzapp/100448328/305C304754C508D506422B2BE2BB8766/100","sd":"","xw":"五阶破空","hits":"29","goods":0,"bads":0,"dpcount":5,"dpfen":"9.9","addtime":"2019-06-14 12:27","sht":"06-14"},{"id":"1033349","title":"有能耐 有脾气","summary":"有能耐 有脾气　（文/占武）　　有能耐的人都有脾气，这是不争的事实，老话说得好，\u201c官升脾气大\u201d我想就是这个道理。如果你的能耐优于身边的人，控制好自己的脾气，养成","classname":"人生感悟","userid":"225292","author":"占武","headurl":"","sd":"lizhanw","xw":"仙阶中级","hits":"27","goods":0,"bads":0,"dpcount":4,"dpfen":"8.5","addtime":"2019-06-13 20:31","sht":"06-14"},{"id":"1033351","title":"一个忧伤的名字","summary":"如果你慷慨地把爱的阳光洒进我纷扰的心房，我就不会像个固执己见的小孩那样乱发脾气；可你吝啬的连个拥抱都不愿意给，我只能呆在一旁默然奢望，奢望靠在你宽阔的臂膀，感受","classname":"心情文章","userid":"232313","author":"绿无忧","headurl":"http://www.duwenz.com/space/headimages/232313.jpg","sd":"232313","xw":"五阶初级","hits":"67","goods":1,"bads":0,"dpcount":6,"dpfen":"8.5","addtime":"2019-06-14 05:26","sht":"06-14"},{"id":"1033352","title":"读《纸月亮》","summary":"这篇文章不华丽，却不失优美。你的写作风格十分素雅。真荣幸，似是发现了另一个自己（抱歉，打这种比方可能很不礼貌）；似是触碰到了一束明媚的光丝儿，虽然它细细长长并没","classname":"抒情散文","userid":"213040","author":"阿谀","headurl":"http://www.duwenz.com/space/headimages/213040.jpg","sd":"213040","xw":"五阶中级","hits":"33","goods":0,"bads":0,"dpcount":5,"dpfen":"8.3","addtime":"2019-06-14 07:58","sht":"06-14"},{"id":"1033347","title":"红楼幽梦","summary":"\u201c花谢花飞飞满天，红消香断有谁怜\u2026\u2026\u201d听着荡心的旋律，踩着时空的记忆，恍若来到了大观园，看到黛玉葬花的凄凉，娇弱如弱柳的她看着花落，早已泪湿眼眶，独把花锄将落红","classname":"抒情散文","userid":"235915","author":"风留香","headurl":"http://qzapp.qlogo.cn/qzapp/100448328/D9F523FF9F664A2896A07A2499EE485E/100","sd":"","xw":"一阶初级","hits":"260","goods":2,"bads":0,"dpcount":4,"dpfen":"9.9","addtime":"2019-06-13 10:28","sht":"06-13"},{"id":"1033345","title":"六月，飞梦的季节","summary":"【图】高考结束的哨声嘎然而止，万千学子们像决了堤的端午洪水，汹涌冲刺而出，这是旗开得胜释放情怀的一种喜悦，这是蚕蜕多年寒窗拼搏获得新生的一种向往，这是人生中最漂亮的一","classname":"心情文章","userid":"211807","author":"追梦的人","headurl":"http://www.duwenz.com/space/headimages/211807.jpg","sd":"211807","xw":"仙阶大成","hits":"268","goods":5,"bads":0,"dpcount":6,"dpfen":"9.5","addtime":"2019-06-13 09:59","sht":"06-13"},{"id":"1033348","title":"最富有的小饭摊","summary":"路边有一个特别引人注目的摊子是买盒饭的。红色的大伞在恹恹地阳光下发出暧昧的红光。它们和着清亮的嗓音叩击在那一张暖黄色的掉了漆的小桌子上，说它小还真没错，每个人坐","classname":"心情文章","userid":"139456","author":"殇\u2014夜之睛","headurl":"http://qzapp.qlogo.cn/qzapp/100448328/37C49ED4619F4E7A06F6C92D355AFD5E/100","sd":"13935090242","xw":"五阶破空","hits":"96","goods":1,"bads":0,"dpcount":2,"dpfen":"9.5","addtime":"2019-06-13 13:14","sht":"06-13"},{"id":"1033341","title":"朋友","summary":"如果黑暗要一个人跨过，那你要朋友做什么？\u2014\u2014题记　乌云蜷缩成一个中空的圆团，只有猥琐在它们后面的月亮透过中间不规则的空隙撒下一片片暧昧的光。渠沟发出的恶臭，使劲","classname":"情感文章","userid":"139456","author":"殇\u2014夜之睛","headurl":"http://qzapp.qlogo.cn/qzapp/100448328/37C49ED4619F4E7A06F6C92D355AFD5E/100","sd":"13935090242","xw":"五阶破空","hits":"184","goods":2,"bads":0,"dpcount":3,"dpfen":"8.9","addtime":"2019-06-13 01:23","sht":"06-13"},{"id":"1033340","title":"亲爱的，我来了","summary":"今天是农历2017年8月16号，她叫玲儿，今天是她的生日，在她们举办的生日宴会上，她的男友阿明在聚会上送了她一只可爱的毛毛熊，在朋友的各种生日礼物中，这根本算不","classname":"爱情故事","userid":"235901","author":"花落随风","headurl":"http://qzapp.qlogo.cn/qzapp/100448328/26CB8AD94385873871F12A6AB651FBC3/100","sd":"235901","xw":"二阶初级","hits":"149","goods":2,"bads":0,"dpcount":4,"dpfen":"8.9","addtime":"2019-06-12 23:46","sht":"06-13"},{"id":"1033346","title":"生命不能承受之轻","summary":"唏嘘时间，总是抓不住时间。时间像手里紧紧握住的流沙，越是紧越是流逝。最近看了一部电影,《妈阁是座城》。电影是以时间的线索来讲述故事，故事也很简单：赌。一个女人站","classname":"人生感悟","userid":"101795","author":"瑾梅","headurl":"http://www.duwenz.com/space/headimages/101795.jpg","sd":"101795","xw":"五阶绝世","hits":"147","goods":5,"bads":0,"dpcount":7,"dpfen":"8.9","addtime":"2019-06-13 10:25","sht":"06-13"},{"id":"1033336","title":"铜火锅","summary":"铜火锅　（文/占武）　　我家有个祖传的铜火锅，具体是什么年代的火锅，家里已经没有人能够说得清楚，只知道是从爷爷那辈传下来的，我想，流传到现在也算是一个物件吧。　","classname":"亲情文章","userid":"225292","author":"占武","headurl":"","sd":"lizhanw","xw":"仙阶中级","hits":"69","goods":1,"bads":0,"dpcount":5,"dpfen":"8.5","addtime":"2019-06-12 18:24","sht":"06-13"},{"id":"1033342","title":"书信与网络","summary":"那时候，一封书信，需要几天的时间才能传递给对方，而且内容皆是重点，毕竟一封书信，不可能长篇大论、事无巨细。而今，分分秒秒变可以做到了。　可曾有过一种感觉？交代后","classname":"心情文章","userid":"139127","author":"小轩","headurl":"http://www.duwenz.com/space/headimages/139127.jpg","sd":"139127","xw":"神王中级","hits":"101","goods":3,"bads":0,"dpcount":3,"dpfen":"8.5","addtime":"2019-06-13 04:15","sht":"06-13"},{"id":"1033320","title":"人的意义","summary":"人的意义是什么，这是被现代这个社会所淡化的一个东西，很多人都不清自己作为人的意义了，很多人会说人的意义不就是取得一番成就实现自己的人生价值吗？也许你错了，这只是","classname":"情感文章","userid":"170607","author":"心灵画师","headurl":"http://www.duwenz.com/space/headimages/170607.jpg","sd":"170607","xw":"神皇高级","hits":"166","goods":1,"bads":0,"dpcount":11,"dpfen":"9.6","addtime":"2019-06-12 01:18","sht":"06-12"},{"id":"1033326","title":"我的摩托车","summary":"《我的摩托车》　文/占武　　2003年，我在双塔山鸟语林风景区承包了一家饭店，那时新修的公路还没有通公交车，从风景区到公路还有很长一段山路，人们出来进去的都要步","classname":"心情文章","userid":"225292","author":"占武","headurl":"","sd":"lizhanw","xw":"仙阶中级","hits":"62","goods":1,"bads":0,"dpcount":2,"dpfen":"8.8","addtime":"2019-06-12 18:07","sht":"06-12"},{"id":"1033331","title":"跑步机的温暖","summary":"跑步机的温暖　（文/占武）　　女儿在国外留学，每天晚上都和我用手机视频聊天，当她看到国内雾霾严重，难见蓝天的状况，心里非常担忧，她知道我每天清晨，晚饭后都有到河","classname":"亲情文章","userid":"225292","author":"占武","headurl":"","sd":"lizhanw","xw":"仙阶中级","hits":"51","goods":1,"bads":0,"dpcount":2,"dpfen":"8.6","addtime":"2019-06-12 18:14","sht":"06-12"},{"id":"1033335","title":"我的呢子大衣","summary":"我的呢子大衣　（文/占武）　　清晨，一轮硕大的红日跳出东方地平线，光芒四射的火球晃得人睁不开眼，老伴对我说，\u201c今天的太阳真足，咱们把大衣橱的衣服晾一下，别让衣服","classname":"心情文章","userid":"225292","author":"占武","headurl":"","sd":"lizhanw","xw":"仙阶中级","hits":"52","goods":1,"bads":0,"dpcount":4,"dpfen":"8.3","addtime":"2019-06-12 18:20","sht":"06-12"},{"id":"1033332","title":"相约旧金山","summary":"《相约旧金山》　（李博口述/占武整理）　　新年前夕我踏上了飞往美国的国际班机，仰靠在舒适的座椅上我一夜无眠，飞机在霞光中平稳降落在美国加州首府旧金山国际机场。走","classname":"心情文章","userid":"225292","author":"占武","headurl":"","sd":"lizhanw","xw":"仙阶中级","hits":"46","goods":1,"bads":0,"dpcount":3,"dpfen":"8","addtime":"2019-06-12 18:16","sht":"06-12"},{"id":"9001966","title":"仡侨","summary":"我认为我是一个不善于表达的人，更不像是一个写作的人。可因为有了从小到大的这些经历，见过许多人，也遇到过许多的事，我才有了把它们记录下来的意念　　老屋　　20岁的","classname":"生活情感","userid":"213881","author":"谨石","headurl":"http://www.duwenz.com/space/headimages/213881.jpg","sd":"js2323","xw":"五阶中级","hits":"1212","goods":15,"bads":0,"dpcount":11,"dpfen":"9.5","addtime":"2019-05-01 05:43","sht":"06-11"},{"id":"1031000","title":"谍海玫瑰","summary":"前言　　1946年初，国民党军进驻山东后，在济南成立第二绥靖区司令部，并迅疾派遣了12个谍报组，分布在全省各地，统归绥靖区二处指挥。1946年10月，时任军事委","classname":"励志故事","userid":"70230","author":"笔耕","headurl":"http://www.duwenz.com/space/headimages/70230.jpg","sd":"70230","xw":"灭天二级","hits":"3622","goods":75,"bads":0,"dpcount":25,"dpfen":"9.5","addtime":"2018-11-07 12:13","sht":"06-11"},{"id":"1033309","title":"岁月流","summary":"目至所极，锁住流云，株瘦难倾诉，托思难消愁，任行云挣脱束缚，随风去流浪！剩下清谈，与蓝天拉近，与碧水一起缱绻，那连接苍穹下，寂寥伴着消瘦，御风摆，难系心殇。抛开","classname":"人生感悟","userid":"209049","author":"吴刚","headurl":"http://www.duwenz.com/space/headimages/209049.jpg","sd":"209049","xw":"五阶高级","hits":"109","goods":6,"bads":0,"dpcount":5,"dpfen":"9.7","addtime":"2019-06-10 13:28","sht":"06-10"},{"id":"1033305","title":"风雨不惊，岁月从容","summary":"由于要去老家接母亲到我工作的学校，所以才吃过中饭就开车出来了。我虽有些五音不全，却总喜欢胡编乱造地哼唱几句，放松一下心情。妻在副驾驶室上昏昏欲睡，我的\u201c天籁之音","classname":"情感文章","userid":"187638","author":"松兰","headurl":"http://www.duwenz.com/space/headimages/187638.jpg","sd":"187638","xw":"神王初级","hits":"116","goods":3,"bads":0,"dpcount":3,"dpfen":"9","addtime":"2019-06-10 08:15","sht":"06-10"}]
     */

    private String getstate;
    private String action;
    private int pageindex;
    private int pagesize;
    private int pagecount;
    private int rows;
    private int lists;
    private String time;
    @SerializedName("token")
    private String Token;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    private List<ListBean> list;

    public WenZhanBean() {
    }

    public String getGetstate() {
        return getstate;
    }

    public void setGetstate(String getstate) {
        this.getstate = getstate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getPageindex() {
        return pageindex;
    }

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPagecount() {
        return pagecount;
    }

    public void setPagecount(int pagecount) {
        this.pagecount = pagecount;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getLists() {
        return lists;
    }

    public void setLists(int lists) {
        this.lists = lists;
    }

    @Bindable
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
        notifyPropertyChanged(BR.time);
    }

    public List<WenZhanBean.ListBean> getList() {
        return list;
    }

    public void setList(List<WenZhanBean.ListBean> list) {
        this.list = list;
    }


    public class ListBean {
        /**
         * id : 1033387
         * title : 送你一生的温暖
         * summary : 她并非凡俗女子，相反，相当优秀，追求者云集。而她，排开众人，毅然跟了他。当时，他一无所有，在一家工厂打工，收入不够解决两人温饱。为了他，她失去亲人，丢了工作。他
         * classname : 爱情故事
         * userid : 235901
         * author : 花落随风
         * headurl : http://qzapp.qlogo.cn/qzapp/100448328/26CB8AD94385873871F12A6AB651FBC3/100
         * sd : 235901
         * xw : 二阶初级
         * hits : 22
         * goods : 0
         * bads : 0
         * dpcount : 2
         * dpfen : 9.9
         * addtime : 2019-06-16 15:05
         * sht : 06-16
         */

        private String id;
        private String title;
        private String summary;
        private String classname;
        private String userid;
        private String author;
        private String headurl;
        private String sd;
        private String xw;
        private String hits;
        private int goods;
        private int bads;
        private int dpcount;
        private String dpfen;
        private String addtime;
        private String sht;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getClassname() {
            return classname;
        }

        public void setClassname(String classname) {
            this.classname = classname;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getHeadurl() {
            return headurl;
        }

        public void setHeadurl(String headurl) {
            this.headurl = headurl;
        }

        public String getSd() {
            return sd;
        }

        public void setSd(String sd) {
            this.sd = sd;
        }

        public String getXw() {
            return xw;
        }

        public void setXw(String xw) {
            this.xw = xw;
        }

        public String getHits() {
            return hits;
        }

        public void setHits(String hits) {
            this.hits = hits;
        }

        public int getGoods() {
            return goods;
        }

        public void setGoods(int goods) {
            this.goods = goods;
        }

        public int getBads() {
            return bads;
        }

        public void setBads(int bads) {
            this.bads = bads;
        }

        public int getDpcount() {
            return dpcount;
        }

        public void setDpcount(int dpcount) {
            this.dpcount = dpcount;
        }

        public String getDpfen() {
            return dpfen;
        }

        public void setDpfen(String dpfen) {
            this.dpfen = dpfen;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getSht() {
            return sht;
        }

        public void setSht(String sht) {
            this.sht = sht;
        }
    }

    @Override
    public String toString() {
        return "WenZhanBean{" +
                "getstate='" + getstate + '\'' +
                ", action='" + action + '\'' +
                ", pageindex=" + pageindex +
                ", pagesize=" + pagesize +
                ", pagecount=" + pagecount +
                ", rows=" + rows +
                ", lists=" + lists +
                ", time='" + time + '\'' +
                ", Token='" + Token + '\'' +
                ", list=" + list +
                '}';
    }
}
