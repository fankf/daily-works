package com.fans.bean;

import java.util.List;

/**
 * @author fankf
 * @date 2021/6/7 16:42
 * @description
 */
public class SourceInfo {

    /**
     * sub_host : ts.voc.com.cn
     * country : 中国
     * eid : [1535]
     * titleHostDup : 0
     * info_type : news
     * media_level : 2
     * gid : 4132385722008322
     * city : 湖南省
     * insert_time : 2018-11-01 15:08:07
     * language : 1
     * industry : [3,5,6,8,9]
     * crawler_no : 192.168.10.193
     * source : 湖南日报《社情民意》
     * title : 投诉深圳前海齐融金融服务有限公司
     * uuid : fee54cd59488dff1d31ca5f5ff1fa254
     * source_url : http://ts.voc.com.cn/question/view/722291.html
     * pictures :
     * content : 10月27日，通过接听电话加了客服刘业龙Qq.，工号0563，说可以代办贷款，咨询中问清需要前期费用没，客服说不需要，结果在app钱包到账后，提现显示密码错误，咨询客服，却和我说先要付6个咨询费才可以提现，我当时觉得不对劲，就说不办了取消掉，他说超过时效会自动取消，我说具体时间，他含糊不清，我一再追问后说超过72小时会取消掉，于是我在三天后追寻客服人员，一再不回，现在1号了，却在app发现代还账单，我问客服几次不回，回的时候客服却说我还钱就行了。从头到尾我就没有收到过钱我怎么还？？？？？？我说要报警，他也不怕，天底下没有公理了吗？？？？？？？？
     * url_md5 : fee54cd59488dff1d31ca5f5ff1fa254
     * source_ip : 192.168.10.132
     * es_updatetime : 2019-01-30 11:22:18
     * es_time_stamp : 1548818538602
     * S : isi0
     * k2k_time : 2018-11-01 15:03:02
     * host : voc.com.cn
     * language_str : zh
     * datepublished : 2018-11-01 11:51:00
     * polarity : 3
     * fail_count : 0
     * ref_url : http://ts.voc.com.cn/question/view/722291.html
     * source_type : 4
     * priority : 2
     * pro : 1
     * extract_date : 2018-11-01 11:51:00
     * is_not_dup : 1
     * website_name : 华声在线
     * find_time : 2018-11-01 15:02:49
     * site : 华声在线
     * pubtime : 2018-11-01 11:51:00
     * crawler_type : S7
     * module_url : http://ts.voc.com.cn/note/list/8.html
     * module_name : com.cn_3_szlx
     * region : 0
     * cid : queueDispatcher
     */
    private String sub_host;
    private String country;
    private int titleHostDup;
    private String info_type;
    private int media_level;
    private long gid;
    private String city;
    private String insert_time;
    private int language;
    private String crawler_no;
    private String source;
    private String title;
    private String uuid;
    private String source_url;
    private String pictures;
    private String content;
    private String url_md5;
    private String source_ip;
    private String es_updatetime;
    private long es_time_stamp;
    private String S;
    private String k2k_time;
    private String host;
    private String language_str;
    private String datepublished;
    private int polarity;
    private int fail_count;
    private String ref_url;
    private int source_type;
    private String priority;
    private int pro;
    private String extract_date;
    private int is_not_dup;
    private String website_name;
    private String find_time;
    private String site;
    private String pubtime;
    private String crawler_type;
    private String module_url;
    private String module_name;
    private int region;
    private String cid;
    private List<Integer> eid;
    private List<Integer> industry;

    public String getSub_host() {
        return sub_host;
    }

    public void setSub_host(String sub_host) {
        this.sub_host = sub_host;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTitleHostDup() {
        return titleHostDup;
    }

    public void setTitleHostDup(int titleHostDup) {
        this.titleHostDup = titleHostDup;
    }

    public String getInfo_type() {
        return info_type;
    }

    public void setInfo_type(String info_type) {
        this.info_type = info_type;
    }

    public int getMedia_level() {
        return media_level;
    }

    public void setMedia_level(int media_level) {
        this.media_level = media_level;
    }

    public long getGid() {
        return gid;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInsert_time() {
        return insert_time;
    }

    public void setInsert_time(String insert_time) {
        this.insert_time = insert_time;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public String getCrawler_no() {
        return crawler_no;
    }

    public void setCrawler_no(String crawler_no) {
        this.crawler_no = crawler_no;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl_md5() {
        return url_md5;
    }

    public void setUrl_md5(String url_md5) {
        this.url_md5 = url_md5;
    }

    public String getSource_ip() {
        return source_ip;
    }

    public void setSource_ip(String source_ip) {
        this.source_ip = source_ip;
    }

    public String getEs_updatetime() {
        return es_updatetime;
    }

    public void setEs_updatetime(String es_updatetime) {
        this.es_updatetime = es_updatetime;
    }

    public long getEs_time_stamp() {
        return es_time_stamp;
    }

    public void setEs_time_stamp(long es_time_stamp) {
        this.es_time_stamp = es_time_stamp;
    }

    public String getS() {
        return S;
    }

    public void setS(String S) {
        this.S = S;
    }

    public String getK2k_time() {
        return k2k_time;
    }

    public void setK2k_time(String k2k_time) {
        this.k2k_time = k2k_time;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getLanguage_str() {
        return language_str;
    }

    public void setLanguage_str(String language_str) {
        this.language_str = language_str;
    }

    public String getDatepublished() {
        return datepublished;
    }

    public void setDatepublished(String datepublished) {
        this.datepublished = datepublished;
    }

    public int getPolarity() {
        return polarity;
    }

    public void setPolarity(int polarity) {
        this.polarity = polarity;
    }

    public int getFail_count() {
        return fail_count;
    }

    public void setFail_count(int fail_count) {
        this.fail_count = fail_count;
    }

    public String getRef_url() {
        return ref_url;
    }

    public void setRef_url(String ref_url) {
        this.ref_url = ref_url;
    }

    public int getSource_type() {
        return source_type;
    }

    public void setSource_type(int source_type) {
        this.source_type = source_type;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getPro() {
        return pro;
    }

    public void setPro(int pro) {
        this.pro = pro;
    }

    public String getExtract_date() {
        return extract_date;
    }

    public void setExtract_date(String extract_date) {
        this.extract_date = extract_date;
    }

    public int getIs_not_dup() {
        return is_not_dup;
    }

    public void setIs_not_dup(int is_not_dup) {
        this.is_not_dup = is_not_dup;
    }

    public String getWebsite_name() {
        return website_name;
    }

    public void setWebsite_name(String website_name) {
        this.website_name = website_name;
    }

    public String getFind_time() {
        return find_time;
    }

    public void setFind_time(String find_time) {
        this.find_time = find_time;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public String getCrawler_type() {
        return crawler_type;
    }

    public void setCrawler_type(String crawler_type) {
        this.crawler_type = crawler_type;
    }

    public String getModule_url() {
        return module_url;
    }

    public void setModule_url(String module_url) {
        this.module_url = module_url;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public List<Integer> getEid() {
        return eid;
    }

    public void setEid(List<Integer> eid) {
        this.eid = eid;
    }

    public List<Integer> getIndustry() {
        return industry;
    }

    public void setIndustry(List<Integer> industry) {
        this.industry = industry;
    }
}
