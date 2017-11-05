package com.chinasofti.mall.common.entity.goods;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ChnGoodsinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChnGoodsinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdsIsNull() {
            addCriterion("IDS is null");
            return (Criteria) this;
        }

        public Criteria andIdsIsNotNull() {
            addCriterion("IDS is not null");
            return (Criteria) this;
        }

        public Criteria andIdsEqualTo(String value) {
            addCriterion("IDS =", value, "ids");
            return (Criteria) this;
        }

        public Criteria andIdsNotEqualTo(String value) {
            addCriterion("IDS <>", value, "ids");
            return (Criteria) this;
        }

        public Criteria andIdsGreaterThan(String value) {
            addCriterion("IDS >", value, "ids");
            return (Criteria) this;
        }

        public Criteria andIdsGreaterThanOrEqualTo(String value) {
            addCriterion("IDS >=", value, "ids");
            return (Criteria) this;
        }

        public Criteria andIdsLessThan(String value) {
            addCriterion("IDS <", value, "ids");
            return (Criteria) this;
        }

        public Criteria andIdsLessThanOrEqualTo(String value) {
            addCriterion("IDS <=", value, "ids");
            return (Criteria) this;
        }

        public Criteria andIdsLike(String value) {
            addCriterion("IDS like", value, "ids");
            return (Criteria) this;
        }

        public Criteria andIdsNotLike(String value) {
            addCriterion("IDS not like", value, "ids");
            return (Criteria) this;
        }

        public Criteria andIdsIn(List<String> values) {
            addCriterion("IDS in", values, "ids");
            return (Criteria) this;
        }

        public Criteria andIdsNotIn(List<String> values) {
            addCriterion("IDS not in", values, "ids");
            return (Criteria) this;
        }

        public Criteria andIdsBetween(String value1, String value2) {
            addCriterion("IDS between", value1, value2, "ids");
            return (Criteria) this;
        }

        public Criteria andIdsNotBetween(String value1, String value2) {
            addCriterion("IDS not between", value1, value2, "ids");
            return (Criteria) this;
        }

        public Criteria andVendoridsIsNull() {
            addCriterion("VENDORIDS is null");
            return (Criteria) this;
        }

        public Criteria andVendoridsIsNotNull() {
            addCriterion("VENDORIDS is not null");
            return (Criteria) this;
        }

        public Criteria andVendoridsEqualTo(String value) {
            addCriterion("VENDORIDS =", value, "vendorids");
            return (Criteria) this;
        }

        public Criteria andVendoridsNotEqualTo(String value) {
            addCriterion("VENDORIDS <>", value, "vendorids");
            return (Criteria) this;
        }

        public Criteria andVendoridsGreaterThan(String value) {
            addCriterion("VENDORIDS >", value, "vendorids");
            return (Criteria) this;
        }

        public Criteria andVendoridsGreaterThanOrEqualTo(String value) {
            addCriterion("VENDORIDS >=", value, "vendorids");
            return (Criteria) this;
        }

        public Criteria andVendoridsLessThan(String value) {
            addCriterion("VENDORIDS <", value, "vendorids");
            return (Criteria) this;
        }

        public Criteria andVendoridsLessThanOrEqualTo(String value) {
            addCriterion("VENDORIDS <=", value, "vendorids");
            return (Criteria) this;
        }

        public Criteria andVendoridsLike(String value) {
            addCriterion("VENDORIDS like", value, "vendorids");
            return (Criteria) this;
        }

        public Criteria andVendoridsNotLike(String value) {
            addCriterion("VENDORIDS not like", value, "vendorids");
            return (Criteria) this;
        }

        public Criteria andVendoridsIn(List<String> values) {
            addCriterion("VENDORIDS in", values, "vendorids");
            return (Criteria) this;
        }

        public Criteria andVendoridsNotIn(List<String> values) {
            addCriterion("VENDORIDS not in", values, "vendorids");
            return (Criteria) this;
        }

        public Criteria andVendoridsBetween(String value1, String value2) {
            addCriterion("VENDORIDS between", value1, value2, "vendorids");
            return (Criteria) this;
        }

        public Criteria andVendoridsNotBetween(String value1, String value2) {
            addCriterion("VENDORIDS not between", value1, value2, "vendorids");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andMouthTradeIsNull() {
            addCriterion("MOUTH_TRADE is null");
            return (Criteria) this;
        }

        public Criteria andMouthTradeIsNotNull() {
            addCriterion("MOUTH_TRADE is not null");
            return (Criteria) this;
        }

        public Criteria andMouthTradeEqualTo(BigDecimal value) {
            addCriterion("MOUTH_TRADE =", value, "mouthTrade");
            return (Criteria) this;
        }

        public Criteria andMouthTradeNotEqualTo(BigDecimal value) {
            addCriterion("MOUTH_TRADE <>", value, "mouthTrade");
            return (Criteria) this;
        }

        public Criteria andMouthTradeGreaterThan(BigDecimal value) {
            addCriterion("MOUTH_TRADE >", value, "mouthTrade");
            return (Criteria) this;
        }

        public Criteria andMouthTradeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MOUTH_TRADE >=", value, "mouthTrade");
            return (Criteria) this;
        }

        public Criteria andMouthTradeLessThan(BigDecimal value) {
            addCriterion("MOUTH_TRADE <", value, "mouthTrade");
            return (Criteria) this;
        }

        public Criteria andMouthTradeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MOUTH_TRADE <=", value, "mouthTrade");
            return (Criteria) this;
        }

        public Criteria andMouthTradeIn(List<BigDecimal> values) {
            addCriterion("MOUTH_TRADE in", values, "mouthTrade");
            return (Criteria) this;
        }

        public Criteria andMouthTradeNotIn(List<BigDecimal> values) {
            addCriterion("MOUTH_TRADE not in", values, "mouthTrade");
            return (Criteria) this;
        }

        public Criteria andMouthTradeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MOUTH_TRADE between", value1, value2, "mouthTrade");
            return (Criteria) this;
        }

        public Criteria andMouthTradeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MOUTH_TRADE not between", value1, value2, "mouthTrade");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNull() {
            addCriterion("SUBTITLE is null");
            return (Criteria) this;
        }

        public Criteria andSubtitleIsNotNull() {
            addCriterion("SUBTITLE is not null");
            return (Criteria) this;
        }

        public Criteria andSubtitleEqualTo(String value) {
            addCriterion("SUBTITLE =", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotEqualTo(String value) {
            addCriterion("SUBTITLE <>", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThan(String value) {
            addCriterion("SUBTITLE >", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("SUBTITLE >=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThan(String value) {
            addCriterion("SUBTITLE <", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLessThanOrEqualTo(String value) {
            addCriterion("SUBTITLE <=", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleLike(String value) {
            addCriterion("SUBTITLE like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotLike(String value) {
            addCriterion("SUBTITLE not like", value, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleIn(List<String> values) {
            addCriterion("SUBTITLE in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotIn(List<String> values) {
            addCriterion("SUBTITLE not in", values, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleBetween(String value1, String value2) {
            addCriterion("SUBTITLE between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andSubtitleNotBetween(String value1, String value2) {
            addCriterion("SUBTITLE not between", value1, value2, "subtitle");
            return (Criteria) this;
        }

        public Criteria andCommonIsNull() {
            addCriterion("COMMON is null");
            return (Criteria) this;
        }

        public Criteria andCommonIsNotNull() {
            addCriterion("COMMON is not null");
            return (Criteria) this;
        }

        public Criteria andCommonEqualTo(String value) {
            addCriterion("COMMON =", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonNotEqualTo(String value) {
            addCriterion("COMMON <>", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonGreaterThan(String value) {
            addCriterion("COMMON >", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonGreaterThanOrEqualTo(String value) {
            addCriterion("COMMON >=", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonLessThan(String value) {
            addCriterion("COMMON <", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonLessThanOrEqualTo(String value) {
            addCriterion("COMMON <=", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonLike(String value) {
            addCriterion("COMMON like", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonNotLike(String value) {
            addCriterion("COMMON not like", value, "common");
            return (Criteria) this;
        }

        public Criteria andCommonIn(List<String> values) {
            addCriterion("COMMON in", values, "common");
            return (Criteria) this;
        }

        public Criteria andCommonNotIn(List<String> values) {
            addCriterion("COMMON not in", values, "common");
            return (Criteria) this;
        }

        public Criteria andCommonBetween(String value1, String value2) {
            addCriterion("COMMON between", value1, value2, "common");
            return (Criteria) this;
        }

        public Criteria andCommonNotBetween(String value1, String value2) {
            addCriterion("COMMON not between", value1, value2, "common");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDisPriceIsNull() {
            addCriterion("DIS_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andDisPriceIsNotNull() {
            addCriterion("DIS_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andDisPriceEqualTo(BigDecimal value) {
            addCriterion("DIS_PRICE =", value, "disPrice");
            return (Criteria) this;
        }

        public Criteria andDisPriceNotEqualTo(BigDecimal value) {
            addCriterion("DIS_PRICE <>", value, "disPrice");
            return (Criteria) this;
        }

        public Criteria andDisPriceGreaterThan(BigDecimal value) {
            addCriterion("DIS_PRICE >", value, "disPrice");
            return (Criteria) this;
        }

        public Criteria andDisPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DIS_PRICE >=", value, "disPrice");
            return (Criteria) this;
        }

        public Criteria andDisPriceLessThan(BigDecimal value) {
            addCriterion("DIS_PRICE <", value, "disPrice");
            return (Criteria) this;
        }

        public Criteria andDisPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DIS_PRICE <=", value, "disPrice");
            return (Criteria) this;
        }

        public Criteria andDisPriceIn(List<BigDecimal> values) {
            addCriterion("DIS_PRICE in", values, "disPrice");
            return (Criteria) this;
        }

        public Criteria andDisPriceNotIn(List<BigDecimal> values) {
            addCriterion("DIS_PRICE not in", values, "disPrice");
            return (Criteria) this;
        }

        public Criteria andDisPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DIS_PRICE between", value1, value2, "disPrice");
            return (Criteria) this;
        }

        public Criteria andDisPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DIS_PRICE not between", value1, value2, "disPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsIsNull() {
            addCriterion("GOODS_CLASS_IDS is null");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsIsNotNull() {
            addCriterion("GOODS_CLASS_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsEqualTo(String value) {
            addCriterion("GOODS_CLASS_IDS =", value, "goodsClassIds");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsNotEqualTo(String value) {
            addCriterion("GOODS_CLASS_IDS <>", value, "goodsClassIds");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsGreaterThan(String value) {
            addCriterion("GOODS_CLASS_IDS >", value, "goodsClassIds");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_CLASS_IDS >=", value, "goodsClassIds");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsLessThan(String value) {
            addCriterion("GOODS_CLASS_IDS <", value, "goodsClassIds");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsLessThanOrEqualTo(String value) {
            addCriterion("GOODS_CLASS_IDS <=", value, "goodsClassIds");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsLike(String value) {
            addCriterion("GOODS_CLASS_IDS like", value, "goodsClassIds");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsNotLike(String value) {
            addCriterion("GOODS_CLASS_IDS not like", value, "goodsClassIds");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsIn(List<String> values) {
            addCriterion("GOODS_CLASS_IDS in", values, "goodsClassIds");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsNotIn(List<String> values) {
            addCriterion("GOODS_CLASS_IDS not in", values, "goodsClassIds");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsBetween(String value1, String value2) {
            addCriterion("GOODS_CLASS_IDS between", value1, value2, "goodsClassIds");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdsNotBetween(String value1, String value2) {
            addCriterion("GOODS_CLASS_IDS not between", value1, value2, "goodsClassIds");
            return (Criteria) this;
        }

        public Criteria andStandardIsNull() {
            addCriterion("STANDARD is null");
            return (Criteria) this;
        }

        public Criteria andStandardIsNotNull() {
            addCriterion("STANDARD is not null");
            return (Criteria) this;
        }

        public Criteria andStandardEqualTo(String value) {
            addCriterion("STANDARD =", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotEqualTo(String value) {
            addCriterion("STANDARD <>", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThan(String value) {
            addCriterion("STANDARD >", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardGreaterThanOrEqualTo(String value) {
            addCriterion("STANDARD >=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThan(String value) {
            addCriterion("STANDARD <", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLessThanOrEqualTo(String value) {
            addCriterion("STANDARD <=", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardLike(String value) {
            addCriterion("STANDARD like", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotLike(String value) {
            addCriterion("STANDARD not like", value, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardIn(List<String> values) {
            addCriterion("STANDARD in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotIn(List<String> values) {
            addCriterion("STANDARD not in", values, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardBetween(String value1, String value2) {
            addCriterion("STANDARD between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andStandardNotBetween(String value1, String value2) {
            addCriterion("STANDARD not between", value1, value2, "standard");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("CONTENT =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("CONTENT <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("CONTENT >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("CONTENT >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("CONTENT <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("CONTENT <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("CONTENT like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("CONTENT not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("CONTENT in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("CONTENT not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("CONTENT between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("CONTENT not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andStoreNumIsNull() {
            addCriterion("STORE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andStoreNumIsNotNull() {
            addCriterion("STORE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNumEqualTo(BigDecimal value) {
            addCriterion("STORE_NUM =", value, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumNotEqualTo(BigDecimal value) {
            addCriterion("STORE_NUM <>", value, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumGreaterThan(BigDecimal value) {
            addCriterion("STORE_NUM >", value, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STORE_NUM >=", value, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumLessThan(BigDecimal value) {
            addCriterion("STORE_NUM <", value, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STORE_NUM <=", value, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumIn(List<BigDecimal> values) {
            addCriterion("STORE_NUM in", values, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumNotIn(List<BigDecimal> values) {
            addCriterion("STORE_NUM not in", values, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STORE_NUM between", value1, value2, "storeNum");
            return (Criteria) this;
        }

        public Criteria andStoreNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STORE_NUM not between", value1, value2, "storeNum");
            return (Criteria) this;
        }

        public Criteria andReviewDescIsNull() {
            addCriterion("REVIEW_DESC is null");
            return (Criteria) this;
        }

        public Criteria andReviewDescIsNotNull() {
            addCriterion("REVIEW_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andReviewDescEqualTo(String value) {
            addCriterion("REVIEW_DESC =", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescNotEqualTo(String value) {
            addCriterion("REVIEW_DESC <>", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescGreaterThan(String value) {
            addCriterion("REVIEW_DESC >", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescGreaterThanOrEqualTo(String value) {
            addCriterion("REVIEW_DESC >=", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescLessThan(String value) {
            addCriterion("REVIEW_DESC <", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescLessThanOrEqualTo(String value) {
            addCriterion("REVIEW_DESC <=", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescLike(String value) {
            addCriterion("REVIEW_DESC like", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescNotLike(String value) {
            addCriterion("REVIEW_DESC not like", value, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescIn(List<String> values) {
            addCriterion("REVIEW_DESC in", values, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescNotIn(List<String> values) {
            addCriterion("REVIEW_DESC not in", values, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescBetween(String value1, String value2) {
            addCriterion("REVIEW_DESC between", value1, value2, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewDescNotBetween(String value1, String value2) {
            addCriterion("REVIEW_DESC not between", value1, value2, "reviewDesc");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesIsNull() {
            addCriterion("REVIEW_STATUES is null");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesIsNotNull() {
            addCriterion("REVIEW_STATUES is not null");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesEqualTo(String value) {
            addCriterion("REVIEW_STATUES =", value, "reviewStatues");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesNotEqualTo(String value) {
            addCriterion("REVIEW_STATUES <>", value, "reviewStatues");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesGreaterThan(String value) {
            addCriterion("REVIEW_STATUES >", value, "reviewStatues");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesGreaterThanOrEqualTo(String value) {
            addCriterion("REVIEW_STATUES >=", value, "reviewStatues");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesLessThan(String value) {
            addCriterion("REVIEW_STATUES <", value, "reviewStatues");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesLessThanOrEqualTo(String value) {
            addCriterion("REVIEW_STATUES <=", value, "reviewStatues");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesLike(String value) {
            addCriterion("REVIEW_STATUES like", value, "reviewStatues");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesNotLike(String value) {
            addCriterion("REVIEW_STATUES not like", value, "reviewStatues");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesIn(List<String> values) {
            addCriterion("REVIEW_STATUES in", values, "reviewStatues");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesNotIn(List<String> values) {
            addCriterion("REVIEW_STATUES not in", values, "reviewStatues");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesBetween(String value1, String value2) {
            addCriterion("REVIEW_STATUES between", value1, value2, "reviewStatues");
            return (Criteria) this;
        }

        public Criteria andReviewStatuesNotBetween(String value1, String value2) {
            addCriterion("REVIEW_STATUES not between", value1, value2, "reviewStatues");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("UPDATE_BY =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("UPDATE_BY <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("UPDATE_BY >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("UPDATE_BY <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_BY <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("UPDATE_BY like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("UPDATE_BY not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("UPDATE_BY in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("UPDATE_BY not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("UPDATE_BY between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("UPDATE_BY not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("UPDATE_TIME like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("UPDATE_TIME not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("CREATE_BY =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("CREATE_BY <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("CREATE_BY >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_BY >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("CREATE_BY <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("CREATE_BY <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("CREATE_BY like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("CREATE_BY not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("CREATE_BY in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("CREATE_BY not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("CREATE_BY between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("CREATE_BY not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("CREATE_TIME like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("CREATE_TIME not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCollNumIsNull() {
            addCriterion("COLL_NUM is null");
            return (Criteria) this;
        }

        public Criteria andCollNumIsNotNull() {
            addCriterion("COLL_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andCollNumEqualTo(BigDecimal value) {
            addCriterion("COLL_NUM =", value, "collNum");
            return (Criteria) this;
        }

        public Criteria andCollNumNotEqualTo(BigDecimal value) {
            addCriterion("COLL_NUM <>", value, "collNum");
            return (Criteria) this;
        }

        public Criteria andCollNumGreaterThan(BigDecimal value) {
            addCriterion("COLL_NUM >", value, "collNum");
            return (Criteria) this;
        }

        public Criteria andCollNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COLL_NUM >=", value, "collNum");
            return (Criteria) this;
        }

        public Criteria andCollNumLessThan(BigDecimal value) {
            addCriterion("COLL_NUM <", value, "collNum");
            return (Criteria) this;
        }

        public Criteria andCollNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COLL_NUM <=", value, "collNum");
            return (Criteria) this;
        }

        public Criteria andCollNumIn(List<BigDecimal> values) {
            addCriterion("COLL_NUM in", values, "collNum");
            return (Criteria) this;
        }

        public Criteria andCollNumNotIn(List<BigDecimal> values) {
            addCriterion("COLL_NUM not in", values, "collNum");
            return (Criteria) this;
        }

        public Criteria andCollNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COLL_NUM between", value1, value2, "collNum");
            return (Criteria) this;
        }

        public Criteria andCollNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COLL_NUM not between", value1, value2, "collNum");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("START_TIME like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("START_TIME not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("END_TIME like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("END_TIME not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeIsNull() {
            addCriterion("ONLINE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeIsNotNull() {
            addCriterion("ONLINE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeEqualTo(String value) {
            addCriterion("ONLINE_TIME =", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeNotEqualTo(String value) {
            addCriterion("ONLINE_TIME <>", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeGreaterThan(String value) {
            addCriterion("ONLINE_TIME >", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ONLINE_TIME >=", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeLessThan(String value) {
            addCriterion("ONLINE_TIME <", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeLessThanOrEqualTo(String value) {
            addCriterion("ONLINE_TIME <=", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeLike(String value) {
            addCriterion("ONLINE_TIME like", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeNotLike(String value) {
            addCriterion("ONLINE_TIME not like", value, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeIn(List<String> values) {
            addCriterion("ONLINE_TIME in", values, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeNotIn(List<String> values) {
            addCriterion("ONLINE_TIME not in", values, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeBetween(String value1, String value2) {
            addCriterion("ONLINE_TIME between", value1, value2, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andOnlineTimeNotBetween(String value1, String value2) {
            addCriterion("ONLINE_TIME not between", value1, value2, "onlineTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIsNull() {
            addCriterion("LEAVE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIsNotNull() {
            addCriterion("LEAVE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeEqualTo(String value) {
            addCriterion("LEAVE_TIME =", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotEqualTo(String value) {
            addCriterion("LEAVE_TIME <>", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeGreaterThan(String value) {
            addCriterion("LEAVE_TIME >", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeGreaterThanOrEqualTo(String value) {
            addCriterion("LEAVE_TIME >=", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLessThan(String value) {
            addCriterion("LEAVE_TIME <", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLessThanOrEqualTo(String value) {
            addCriterion("LEAVE_TIME <=", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeLike(String value) {
            addCriterion("LEAVE_TIME like", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotLike(String value) {
            addCriterion("LEAVE_TIME not like", value, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeIn(List<String> values) {
            addCriterion("LEAVE_TIME in", values, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotIn(List<String> values) {
            addCriterion("LEAVE_TIME not in", values, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeBetween(String value1, String value2) {
            addCriterion("LEAVE_TIME between", value1, value2, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andLeaveTimeNotBetween(String value1, String value2) {
            addCriterion("LEAVE_TIME not between", value1, value2, "leaveTime");
            return (Criteria) this;
        }

        public Criteria andBrandIdsIsNull() {
            addCriterion("BRAND_IDS is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdsIsNotNull() {
            addCriterion("BRAND_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdsEqualTo(String value) {
            addCriterion("BRAND_IDS =", value, "brandIds");
            return (Criteria) this;
        }

        public Criteria andBrandIdsNotEqualTo(String value) {
            addCriterion("BRAND_IDS <>", value, "brandIds");
            return (Criteria) this;
        }

        public Criteria andBrandIdsGreaterThan(String value) {
            addCriterion("BRAND_IDS >", value, "brandIds");
            return (Criteria) this;
        }

        public Criteria andBrandIdsGreaterThanOrEqualTo(String value) {
            addCriterion("BRAND_IDS >=", value, "brandIds");
            return (Criteria) this;
        }

        public Criteria andBrandIdsLessThan(String value) {
            addCriterion("BRAND_IDS <", value, "brandIds");
            return (Criteria) this;
        }

        public Criteria andBrandIdsLessThanOrEqualTo(String value) {
            addCriterion("BRAND_IDS <=", value, "brandIds");
            return (Criteria) this;
        }

        public Criteria andBrandIdsLike(String value) {
            addCriterion("BRAND_IDS like", value, "brandIds");
            return (Criteria) this;
        }

        public Criteria andBrandIdsNotLike(String value) {
            addCriterion("BRAND_IDS not like", value, "brandIds");
            return (Criteria) this;
        }

        public Criteria andBrandIdsIn(List<String> values) {
            addCriterion("BRAND_IDS in", values, "brandIds");
            return (Criteria) this;
        }

        public Criteria andBrandIdsNotIn(List<String> values) {
            addCriterion("BRAND_IDS not in", values, "brandIds");
            return (Criteria) this;
        }

        public Criteria andBrandIdsBetween(String value1, String value2) {
            addCriterion("BRAND_IDS between", value1, value2, "brandIds");
            return (Criteria) this;
        }

        public Criteria andBrandIdsNotBetween(String value1, String value2) {
            addCriterion("BRAND_IDS not between", value1, value2, "brandIds");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("WEIGHT =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("WEIGHT <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("WEIGHT >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WEIGHT >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("WEIGHT <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WEIGHT <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("WEIGHT in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("WEIGHT not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEIGHT between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEIGHT not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andDeliveWayIsNull() {
            addCriterion("DELIVE_WAY is null");
            return (Criteria) this;
        }

        public Criteria andDeliveWayIsNotNull() {
            addCriterion("DELIVE_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveWayEqualTo(String value) {
            addCriterion("DELIVE_WAY =", value, "deliveWay");
            return (Criteria) this;
        }

        public Criteria andDeliveWayNotEqualTo(String value) {
            addCriterion("DELIVE_WAY <>", value, "deliveWay");
            return (Criteria) this;
        }

        public Criteria andDeliveWayGreaterThan(String value) {
            addCriterion("DELIVE_WAY >", value, "deliveWay");
            return (Criteria) this;
        }

        public Criteria andDeliveWayGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVE_WAY >=", value, "deliveWay");
            return (Criteria) this;
        }

        public Criteria andDeliveWayLessThan(String value) {
            addCriterion("DELIVE_WAY <", value, "deliveWay");
            return (Criteria) this;
        }

        public Criteria andDeliveWayLessThanOrEqualTo(String value) {
            addCriterion("DELIVE_WAY <=", value, "deliveWay");
            return (Criteria) this;
        }

        public Criteria andDeliveWayLike(String value) {
            addCriterion("DELIVE_WAY like", value, "deliveWay");
            return (Criteria) this;
        }

        public Criteria andDeliveWayNotLike(String value) {
            addCriterion("DELIVE_WAY not like", value, "deliveWay");
            return (Criteria) this;
        }

        public Criteria andDeliveWayIn(List<String> values) {
            addCriterion("DELIVE_WAY in", values, "deliveWay");
            return (Criteria) this;
        }

        public Criteria andDeliveWayNotIn(List<String> values) {
            addCriterion("DELIVE_WAY not in", values, "deliveWay");
            return (Criteria) this;
        }

        public Criteria andDeliveWayBetween(String value1, String value2) {
            addCriterion("DELIVE_WAY between", value1, value2, "deliveWay");
            return (Criteria) this;
        }

        public Criteria andDeliveWayNotBetween(String value1, String value2) {
            addCriterion("DELIVE_WAY not between", value1, value2, "deliveWay");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameIsNull() {
            addCriterion("IS_DIS_VERDORNAME is null");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameIsNotNull() {
            addCriterion("IS_DIS_VERDORNAME is not null");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameEqualTo(String value) {
            addCriterion("IS_DIS_VERDORNAME =", value, "isDisVerdorname");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameNotEqualTo(String value) {
            addCriterion("IS_DIS_VERDORNAME <>", value, "isDisVerdorname");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameGreaterThan(String value) {
            addCriterion("IS_DIS_VERDORNAME >", value, "isDisVerdorname");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DIS_VERDORNAME >=", value, "isDisVerdorname");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameLessThan(String value) {
            addCriterion("IS_DIS_VERDORNAME <", value, "isDisVerdorname");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameLessThanOrEqualTo(String value) {
            addCriterion("IS_DIS_VERDORNAME <=", value, "isDisVerdorname");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameLike(String value) {
            addCriterion("IS_DIS_VERDORNAME like", value, "isDisVerdorname");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameNotLike(String value) {
            addCriterion("IS_DIS_VERDORNAME not like", value, "isDisVerdorname");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameIn(List<String> values) {
            addCriterion("IS_DIS_VERDORNAME in", values, "isDisVerdorname");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameNotIn(List<String> values) {
            addCriterion("IS_DIS_VERDORNAME not in", values, "isDisVerdorname");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameBetween(String value1, String value2) {
            addCriterion("IS_DIS_VERDORNAME between", value1, value2, "isDisVerdorname");
            return (Criteria) this;
        }

        public Criteria andIsDisVerdornameNotBetween(String value1, String value2) {
            addCriterion("IS_DIS_VERDORNAME not between", value1, value2, "isDisVerdorname");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardIsNull() {
            addCriterion("IS_DIS_STANDARD is null");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardIsNotNull() {
            addCriterion("IS_DIS_STANDARD is not null");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardEqualTo(String value) {
            addCriterion("IS_DIS_STANDARD =", value, "isDisStandard");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardNotEqualTo(String value) {
            addCriterion("IS_DIS_STANDARD <>", value, "isDisStandard");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardGreaterThan(String value) {
            addCriterion("IS_DIS_STANDARD >", value, "isDisStandard");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DIS_STANDARD >=", value, "isDisStandard");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardLessThan(String value) {
            addCriterion("IS_DIS_STANDARD <", value, "isDisStandard");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardLessThanOrEqualTo(String value) {
            addCriterion("IS_DIS_STANDARD <=", value, "isDisStandard");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardLike(String value) {
            addCriterion("IS_DIS_STANDARD like", value, "isDisStandard");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardNotLike(String value) {
            addCriterion("IS_DIS_STANDARD not like", value, "isDisStandard");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardIn(List<String> values) {
            addCriterion("IS_DIS_STANDARD in", values, "isDisStandard");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardNotIn(List<String> values) {
            addCriterion("IS_DIS_STANDARD not in", values, "isDisStandard");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardBetween(String value1, String value2) {
            addCriterion("IS_DIS_STANDARD between", value1, value2, "isDisStandard");
            return (Criteria) this;
        }

        public Criteria andIsDisStandardNotBetween(String value1, String value2) {
            addCriterion("IS_DIS_STANDARD not between", value1, value2, "isDisStandard");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreIsNull() {
            addCriterion("IS_DIS_STORE is null");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreIsNotNull() {
            addCriterion("IS_DIS_STORE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreEqualTo(String value) {
            addCriterion("IS_DIS_STORE =", value, "isDisStore");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreNotEqualTo(String value) {
            addCriterion("IS_DIS_STORE <>", value, "isDisStore");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreGreaterThan(String value) {
            addCriterion("IS_DIS_STORE >", value, "isDisStore");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DIS_STORE >=", value, "isDisStore");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreLessThan(String value) {
            addCriterion("IS_DIS_STORE <", value, "isDisStore");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreLessThanOrEqualTo(String value) {
            addCriterion("IS_DIS_STORE <=", value, "isDisStore");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreLike(String value) {
            addCriterion("IS_DIS_STORE like", value, "isDisStore");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreNotLike(String value) {
            addCriterion("IS_DIS_STORE not like", value, "isDisStore");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreIn(List<String> values) {
            addCriterion("IS_DIS_STORE in", values, "isDisStore");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreNotIn(List<String> values) {
            addCriterion("IS_DIS_STORE not in", values, "isDisStore");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreBetween(String value1, String value2) {
            addCriterion("IS_DIS_STORE between", value1, value2, "isDisStore");
            return (Criteria) this;
        }

        public Criteria andIsDisStoreNotBetween(String value1, String value2) {
            addCriterion("IS_DIS_STORE not between", value1, value2, "isDisStore");
            return (Criteria) this;
        }

        public Criteria andLimitOrderNumIsNull() {
            addCriterion("LIMIT_ORDER_NUM is null");
            return (Criteria) this;
        }

        public Criteria andLimitOrderNumIsNotNull() {
            addCriterion("LIMIT_ORDER_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andLimitOrderNumEqualTo(BigDecimal value) {
            addCriterion("LIMIT_ORDER_NUM =", value, "limitOrderNum");
            return (Criteria) this;
        }

        public Criteria andLimitOrderNumNotEqualTo(BigDecimal value) {
            addCriterion("LIMIT_ORDER_NUM <>", value, "limitOrderNum");
            return (Criteria) this;
        }

        public Criteria andLimitOrderNumGreaterThan(BigDecimal value) {
            addCriterion("LIMIT_ORDER_NUM >", value, "limitOrderNum");
            return (Criteria) this;
        }

        public Criteria andLimitOrderNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LIMIT_ORDER_NUM >=", value, "limitOrderNum");
            return (Criteria) this;
        }

        public Criteria andLimitOrderNumLessThan(BigDecimal value) {
            addCriterion("LIMIT_ORDER_NUM <", value, "limitOrderNum");
            return (Criteria) this;
        }

        public Criteria andLimitOrderNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LIMIT_ORDER_NUM <=", value, "limitOrderNum");
            return (Criteria) this;
        }

        public Criteria andLimitOrderNumIn(List<BigDecimal> values) {
            addCriterion("LIMIT_ORDER_NUM in", values, "limitOrderNum");
            return (Criteria) this;
        }

        public Criteria andLimitOrderNumNotIn(List<BigDecimal> values) {
            addCriterion("LIMIT_ORDER_NUM not in", values, "limitOrderNum");
            return (Criteria) this;
        }

        public Criteria andLimitOrderNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIMIT_ORDER_NUM between", value1, value2, "limitOrderNum");
            return (Criteria) this;
        }

        public Criteria andLimitOrderNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIMIT_ORDER_NUM not between", value1, value2, "limitOrderNum");
            return (Criteria) this;
        }

        public Criteria andReviewByIsNull() {
            addCriterion("REVIEW_BY is null");
            return (Criteria) this;
        }

        public Criteria andReviewByIsNotNull() {
            addCriterion("REVIEW_BY is not null");
            return (Criteria) this;
        }

        public Criteria andReviewByEqualTo(String value) {
            addCriterion("REVIEW_BY =", value, "reviewBy");
            return (Criteria) this;
        }

        public Criteria andReviewByNotEqualTo(String value) {
            addCriterion("REVIEW_BY <>", value, "reviewBy");
            return (Criteria) this;
        }

        public Criteria andReviewByGreaterThan(String value) {
            addCriterion("REVIEW_BY >", value, "reviewBy");
            return (Criteria) this;
        }

        public Criteria andReviewByGreaterThanOrEqualTo(String value) {
            addCriterion("REVIEW_BY >=", value, "reviewBy");
            return (Criteria) this;
        }

        public Criteria andReviewByLessThan(String value) {
            addCriterion("REVIEW_BY <", value, "reviewBy");
            return (Criteria) this;
        }

        public Criteria andReviewByLessThanOrEqualTo(String value) {
            addCriterion("REVIEW_BY <=", value, "reviewBy");
            return (Criteria) this;
        }

        public Criteria andReviewByLike(String value) {
            addCriterion("REVIEW_BY like", value, "reviewBy");
            return (Criteria) this;
        }

        public Criteria andReviewByNotLike(String value) {
            addCriterion("REVIEW_BY not like", value, "reviewBy");
            return (Criteria) this;
        }

        public Criteria andReviewByIn(List<String> values) {
            addCriterion("REVIEW_BY in", values, "reviewBy");
            return (Criteria) this;
        }

        public Criteria andReviewByNotIn(List<String> values) {
            addCriterion("REVIEW_BY not in", values, "reviewBy");
            return (Criteria) this;
        }

        public Criteria andReviewByBetween(String value1, String value2) {
            addCriterion("REVIEW_BY between", value1, value2, "reviewBy");
            return (Criteria) this;
        }

        public Criteria andReviewByNotBetween(String value1, String value2) {
            addCriterion("REVIEW_BY not between", value1, value2, "reviewBy");
            return (Criteria) this;
        }

        public Criteria andReviewTimeIsNull() {
            addCriterion("REVIEW_TIME is null");
            return (Criteria) this;
        }

        public Criteria andReviewTimeIsNotNull() {
            addCriterion("REVIEW_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andReviewTimeEqualTo(String value) {
            addCriterion("REVIEW_TIME =", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotEqualTo(String value) {
            addCriterion("REVIEW_TIME <>", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeGreaterThan(String value) {
            addCriterion("REVIEW_TIME >", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeGreaterThanOrEqualTo(String value) {
            addCriterion("REVIEW_TIME >=", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeLessThan(String value) {
            addCriterion("REVIEW_TIME <", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeLessThanOrEqualTo(String value) {
            addCriterion("REVIEW_TIME <=", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeLike(String value) {
            addCriterion("REVIEW_TIME like", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotLike(String value) {
            addCriterion("REVIEW_TIME not like", value, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeIn(List<String> values) {
            addCriterion("REVIEW_TIME in", values, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotIn(List<String> values) {
            addCriterion("REVIEW_TIME not in", values, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeBetween(String value1, String value2) {
            addCriterion("REVIEW_TIME between", value1, value2, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andReviewTimeNotBetween(String value1, String value2) {
            addCriterion("REVIEW_TIME not between", value1, value2, "reviewTime");
            return (Criteria) this;
        }

        public Criteria andTotalTradeIsNull() {
            addCriterion("TOTAL_TRADE is null");
            return (Criteria) this;
        }

        public Criteria andTotalTradeIsNotNull() {
            addCriterion("TOTAL_TRADE is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTradeEqualTo(BigDecimal value) {
            addCriterion("TOTAL_TRADE =", value, "totalTrade");
            return (Criteria) this;
        }

        public Criteria andTotalTradeNotEqualTo(BigDecimal value) {
            addCriterion("TOTAL_TRADE <>", value, "totalTrade");
            return (Criteria) this;
        }

        public Criteria andTotalTradeGreaterThan(BigDecimal value) {
            addCriterion("TOTAL_TRADE >", value, "totalTrade");
            return (Criteria) this;
        }

        public Criteria andTotalTradeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_TRADE >=", value, "totalTrade");
            return (Criteria) this;
        }

        public Criteria andTotalTradeLessThan(BigDecimal value) {
            addCriterion("TOTAL_TRADE <", value, "totalTrade");
            return (Criteria) this;
        }

        public Criteria andTotalTradeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTAL_TRADE <=", value, "totalTrade");
            return (Criteria) this;
        }

        public Criteria andTotalTradeIn(List<BigDecimal> values) {
            addCriterion("TOTAL_TRADE in", values, "totalTrade");
            return (Criteria) this;
        }

        public Criteria andTotalTradeNotIn(List<BigDecimal> values) {
            addCriterion("TOTAL_TRADE not in", values, "totalTrade");
            return (Criteria) this;
        }

        public Criteria andTotalTradeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_TRADE between", value1, value2, "totalTrade");
            return (Criteria) this;
        }

        public Criteria andTotalTradeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTAL_TRADE not between", value1, value2, "totalTrade");
            return (Criteria) this;
        }

        public Criteria andLimitUserNumIsNull() {
            addCriterion("LIMIT_USER_NUM is null");
            return (Criteria) this;
        }

        public Criteria andLimitUserNumIsNotNull() {
            addCriterion("LIMIT_USER_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andLimitUserNumEqualTo(BigDecimal value) {
            addCriterion("LIMIT_USER_NUM =", value, "limitUserNum");
            return (Criteria) this;
        }

        public Criteria andLimitUserNumNotEqualTo(BigDecimal value) {
            addCriterion("LIMIT_USER_NUM <>", value, "limitUserNum");
            return (Criteria) this;
        }

        public Criteria andLimitUserNumGreaterThan(BigDecimal value) {
            addCriterion("LIMIT_USER_NUM >", value, "limitUserNum");
            return (Criteria) this;
        }

        public Criteria andLimitUserNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LIMIT_USER_NUM >=", value, "limitUserNum");
            return (Criteria) this;
        }

        public Criteria andLimitUserNumLessThan(BigDecimal value) {
            addCriterion("LIMIT_USER_NUM <", value, "limitUserNum");
            return (Criteria) this;
        }

        public Criteria andLimitUserNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LIMIT_USER_NUM <=", value, "limitUserNum");
            return (Criteria) this;
        }

        public Criteria andLimitUserNumIn(List<BigDecimal> values) {
            addCriterion("LIMIT_USER_NUM in", values, "limitUserNum");
            return (Criteria) this;
        }

        public Criteria andLimitUserNumNotIn(List<BigDecimal> values) {
            addCriterion("LIMIT_USER_NUM not in", values, "limitUserNum");
            return (Criteria) this;
        }

        public Criteria andLimitUserNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIMIT_USER_NUM between", value1, value2, "limitUserNum");
            return (Criteria) this;
        }

        public Criteria andLimitUserNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LIMIT_USER_NUM not between", value1, value2, "limitUserNum");
            return (Criteria) this;
        }

        public Criteria andOrgPriceIsNull() {
            addCriterion("ORG_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andOrgPriceIsNotNull() {
            addCriterion("ORG_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPriceEqualTo(BigDecimal value) {
            addCriterion("ORG_PRICE =", value, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceNotEqualTo(BigDecimal value) {
            addCriterion("ORG_PRICE <>", value, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceGreaterThan(BigDecimal value) {
            addCriterion("ORG_PRICE >", value, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORG_PRICE >=", value, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceLessThan(BigDecimal value) {
            addCriterion("ORG_PRICE <", value, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORG_PRICE <=", value, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceIn(List<BigDecimal> values) {
            addCriterion("ORG_PRICE in", values, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceNotIn(List<BigDecimal> values) {
            addCriterion("ORG_PRICE not in", values, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORG_PRICE between", value1, value2, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andOrgPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORG_PRICE not between", value1, value2, "orgPrice");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andIsshowIsNull() {
            addCriterion("ISSHOW is null");
            return (Criteria) this;
        }

        public Criteria andIsshowIsNotNull() {
            addCriterion("ISSHOW is not null");
            return (Criteria) this;
        }

        public Criteria andIsshowEqualTo(String value) {
            addCriterion("ISSHOW =", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowNotEqualTo(String value) {
            addCriterion("ISSHOW <>", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowGreaterThan(String value) {
            addCriterion("ISSHOW >", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowGreaterThanOrEqualTo(String value) {
            addCriterion("ISSHOW >=", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowLessThan(String value) {
            addCriterion("ISSHOW <", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowLessThanOrEqualTo(String value) {
            addCriterion("ISSHOW <=", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowLike(String value) {
            addCriterion("ISSHOW like", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowNotLike(String value) {
            addCriterion("ISSHOW not like", value, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowIn(List<String> values) {
            addCriterion("ISSHOW in", values, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowNotIn(List<String> values) {
            addCriterion("ISSHOW not in", values, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowBetween(String value1, String value2) {
            addCriterion("ISSHOW between", value1, value2, "isshow");
            return (Criteria) this;
        }

        public Criteria andIsshowNotBetween(String value1, String value2) {
            addCriterion("ISSHOW not between", value1, value2, "isshow");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}