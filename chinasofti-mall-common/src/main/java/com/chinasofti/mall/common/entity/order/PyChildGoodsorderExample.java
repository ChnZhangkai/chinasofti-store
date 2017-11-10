package com.chinasofti.mall.common.entity.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PyChildGoodsorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PyChildGoodsorderExample() {
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

        public Criteria andMainorderIdsIsNull() {
            addCriterion("MAINORDER_IDS is null");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsIsNotNull() {
            addCriterion("MAINORDER_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsEqualTo(String value) {
            addCriterion("MAINORDER_IDS =", value, "mainorderIds");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsNotEqualTo(String value) {
            addCriterion("MAINORDER_IDS <>", value, "mainorderIds");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsGreaterThan(String value) {
            addCriterion("MAINORDER_IDS >", value, "mainorderIds");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsGreaterThanOrEqualTo(String value) {
            addCriterion("MAINORDER_IDS >=", value, "mainorderIds");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsLessThan(String value) {
            addCriterion("MAINORDER_IDS <", value, "mainorderIds");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsLessThanOrEqualTo(String value) {
            addCriterion("MAINORDER_IDS <=", value, "mainorderIds");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsLike(String value) {
            addCriterion("MAINORDER_IDS like", value, "mainorderIds");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsNotLike(String value) {
            addCriterion("MAINORDER_IDS not like", value, "mainorderIds");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsIn(List<String> values) {
            addCriterion("MAINORDER_IDS in", values, "mainorderIds");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsNotIn(List<String> values) {
            addCriterion("MAINORDER_IDS not in", values, "mainorderIds");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsBetween(String value1, String value2) {
            addCriterion("MAINORDER_IDS between", value1, value2, "mainorderIds");
            return (Criteria) this;
        }

        public Criteria andMainorderIdsNotBetween(String value1, String value2) {
            addCriterion("MAINORDER_IDS not between", value1, value2, "mainorderIds");
            return (Criteria) this;
        }

        public Criteria andGoodsidsIsNull() {
            addCriterion("GOODSIDS is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidsIsNotNull() {
            addCriterion("GOODSIDS is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidsEqualTo(String value) {
            addCriterion("GOODSIDS =", value, "goodsids");
            return (Criteria) this;
        }

        public Criteria andGoodsidsNotEqualTo(String value) {
            addCriterion("GOODSIDS <>", value, "goodsids");
            return (Criteria) this;
        }

        public Criteria andGoodsidsGreaterThan(String value) {
            addCriterion("GOODSIDS >", value, "goodsids");
            return (Criteria) this;
        }

        public Criteria andGoodsidsGreaterThanOrEqualTo(String value) {
            addCriterion("GOODSIDS >=", value, "goodsids");
            return (Criteria) this;
        }

        public Criteria andGoodsidsLessThan(String value) {
            addCriterion("GOODSIDS <", value, "goodsids");
            return (Criteria) this;
        }

        public Criteria andGoodsidsLessThanOrEqualTo(String value) {
            addCriterion("GOODSIDS <=", value, "goodsids");
            return (Criteria) this;
        }

        public Criteria andGoodsidsLike(String value) {
            addCriterion("GOODSIDS like", value, "goodsids");
            return (Criteria) this;
        }

        public Criteria andGoodsidsNotLike(String value) {
            addCriterion("GOODSIDS not like", value, "goodsids");
            return (Criteria) this;
        }

        public Criteria andGoodsidsIn(List<String> values) {
            addCriterion("GOODSIDS in", values, "goodsids");
            return (Criteria) this;
        }

        public Criteria andGoodsidsNotIn(List<String> values) {
            addCriterion("GOODSIDS not in", values, "goodsids");
            return (Criteria) this;
        }

        public Criteria andGoodsidsBetween(String value1, String value2) {
            addCriterion("GOODSIDS between", value1, value2, "goodsids");
            return (Criteria) this;
        }

        public Criteria andGoodsidsNotBetween(String value1, String value2) {
            addCriterion("GOODSIDS not between", value1, value2, "goodsids");
            return (Criteria) this;
        }

        public Criteria andCustIdsIsNull() {
            addCriterion("CUST_IDS is null");
            return (Criteria) this;
        }

        public Criteria andCustIdsIsNotNull() {
            addCriterion("CUST_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdsEqualTo(String value) {
            addCriterion("CUST_IDS =", value, "custIds");
            return (Criteria) this;
        }

        public Criteria andCustIdsNotEqualTo(String value) {
            addCriterion("CUST_IDS <>", value, "custIds");
            return (Criteria) this;
        }

        public Criteria andCustIdsGreaterThan(String value) {
            addCriterion("CUST_IDS >", value, "custIds");
            return (Criteria) this;
        }

        public Criteria andCustIdsGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_IDS >=", value, "custIds");
            return (Criteria) this;
        }

        public Criteria andCustIdsLessThan(String value) {
            addCriterion("CUST_IDS <", value, "custIds");
            return (Criteria) this;
        }

        public Criteria andCustIdsLessThanOrEqualTo(String value) {
            addCriterion("CUST_IDS <=", value, "custIds");
            return (Criteria) this;
        }

        public Criteria andCustIdsLike(String value) {
            addCriterion("CUST_IDS like", value, "custIds");
            return (Criteria) this;
        }

        public Criteria andCustIdsNotLike(String value) {
            addCriterion("CUST_IDS not like", value, "custIds");
            return (Criteria) this;
        }

        public Criteria andCustIdsIn(List<String> values) {
            addCriterion("CUST_IDS in", values, "custIds");
            return (Criteria) this;
        }

        public Criteria andCustIdsNotIn(List<String> values) {
            addCriterion("CUST_IDS not in", values, "custIds");
            return (Criteria) this;
        }

        public Criteria andCustIdsBetween(String value1, String value2) {
            addCriterion("CUST_IDS between", value1, value2, "custIds");
            return (Criteria) this;
        }

        public Criteria andCustIdsNotBetween(String value1, String value2) {
            addCriterion("CUST_IDS not between", value1, value2, "custIds");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("ORDER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("ORDER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("ORDER_STATUS =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("ORDER_STATUS <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("ORDER_STATUS >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_STATUS >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("ORDER_STATUS <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("ORDER_STATUS <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("ORDER_STATUS like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("ORDER_STATUS not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("ORDER_STATUS in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("ORDER_STATUS not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("ORDER_STATUS between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("ORDER_STATUS not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIsNull() {
            addCriterion("GOODS_NUM is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIsNotNull() {
            addCriterion("GOODS_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumEqualTo(BigDecimal value) {
            addCriterion("GOODS_NUM =", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotEqualTo(BigDecimal value) {
            addCriterion("GOODS_NUM <>", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThan(BigDecimal value) {
            addCriterion("GOODS_NUM >", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_NUM >=", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThan(BigDecimal value) {
            addCriterion("GOODS_NUM <", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_NUM <=", value, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumIn(List<BigDecimal> values) {
            addCriterion("GOODS_NUM in", values, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotIn(List<BigDecimal> values) {
            addCriterion("GOODS_NUM not in", values, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_NUM between", value1, value2, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_NUM not between", value1, value2, "goodsNum");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("GOODS_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("GOODS_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("GOODS_PRICE =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("GOODS_PRICE <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("GOODS_PRICE >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_PRICE >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(BigDecimal value) {
            addCriterion("GOODS_PRICE <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_PRICE <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("GOODS_PRICE in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("GOODS_PRICE not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_PRICE between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_PRICE not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("DISCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("DISCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(BigDecimal value) {
            addCriterion("DISCOUNT =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(BigDecimal value) {
            addCriterion("DISCOUNT <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(BigDecimal value) {
            addCriterion("DISCOUNT >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DISCOUNT >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(BigDecimal value) {
            addCriterion("DISCOUNT <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DISCOUNT <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<BigDecimal> values) {
            addCriterion("DISCOUNT in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<BigDecimal> values) {
            addCriterion("DISCOUNT not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DISCOUNT between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DISCOUNT not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtIsNull() {
            addCriterion("ORDER_REAL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtIsNotNull() {
            addCriterion("ORDER_REAL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtEqualTo(BigDecimal value) {
            addCriterion("ORDER_REAL_AMT =", value, "orderRealAmt");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtNotEqualTo(BigDecimal value) {
            addCriterion("ORDER_REAL_AMT <>", value, "orderRealAmt");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtGreaterThan(BigDecimal value) {
            addCriterion("ORDER_REAL_AMT >", value, "orderRealAmt");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_REAL_AMT >=", value, "orderRealAmt");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtLessThan(BigDecimal value) {
            addCriterion("ORDER_REAL_AMT <", value, "orderRealAmt");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_REAL_AMT <=", value, "orderRealAmt");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtIn(List<BigDecimal> values) {
            addCriterion("ORDER_REAL_AMT in", values, "orderRealAmt");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtNotIn(List<BigDecimal> values) {
            addCriterion("ORDER_REAL_AMT not in", values, "orderRealAmt");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_REAL_AMT between", value1, value2, "orderRealAmt");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_REAL_AMT not between", value1, value2, "orderRealAmt");
            return (Criteria) this;
        }

        public Criteria andIsevaluateIsNull() {
            addCriterion("ISEVALUATE is null");
            return (Criteria) this;
        }

        public Criteria andIsevaluateIsNotNull() {
            addCriterion("ISEVALUATE is not null");
            return (Criteria) this;
        }

        public Criteria andIsevaluateEqualTo(String value) {
            addCriterion("ISEVALUATE =", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateNotEqualTo(String value) {
            addCriterion("ISEVALUATE <>", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateGreaterThan(String value) {
            addCriterion("ISEVALUATE >", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateGreaterThanOrEqualTo(String value) {
            addCriterion("ISEVALUATE >=", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateLessThan(String value) {
            addCriterion("ISEVALUATE <", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateLessThanOrEqualTo(String value) {
            addCriterion("ISEVALUATE <=", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateLike(String value) {
            addCriterion("ISEVALUATE like", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateNotLike(String value) {
            addCriterion("ISEVALUATE not like", value, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateIn(List<String> values) {
            addCriterion("ISEVALUATE in", values, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateNotIn(List<String> values) {
            addCriterion("ISEVALUATE not in", values, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateBetween(String value1, String value2) {
            addCriterion("ISEVALUATE between", value1, value2, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andIsevaluateNotBetween(String value1, String value2) {
            addCriterion("ISEVALUATE not between", value1, value2, "isevaluate");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeIsNull() {
            addCriterion("ORDER_REVOKE is null");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeIsNotNull() {
            addCriterion("ORDER_REVOKE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeEqualTo(String value) {
            addCriterion("ORDER_REVOKE =", value, "orderRevoke");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeNotEqualTo(String value) {
            addCriterion("ORDER_REVOKE <>", value, "orderRevoke");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeGreaterThan(String value) {
            addCriterion("ORDER_REVOKE >", value, "orderRevoke");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_REVOKE >=", value, "orderRevoke");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeLessThan(String value) {
            addCriterion("ORDER_REVOKE <", value, "orderRevoke");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeLessThanOrEqualTo(String value) {
            addCriterion("ORDER_REVOKE <=", value, "orderRevoke");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeLike(String value) {
            addCriterion("ORDER_REVOKE like", value, "orderRevoke");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeNotLike(String value) {
            addCriterion("ORDER_REVOKE not like", value, "orderRevoke");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeIn(List<String> values) {
            addCriterion("ORDER_REVOKE in", values, "orderRevoke");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeNotIn(List<String> values) {
            addCriterion("ORDER_REVOKE not in", values, "orderRevoke");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeBetween(String value1, String value2) {
            addCriterion("ORDER_REVOKE between", value1, value2, "orderRevoke");
            return (Criteria) this;
        }

        public Criteria andOrderRevokeNotBetween(String value1, String value2) {
            addCriterion("ORDER_REVOKE not between", value1, value2, "orderRevoke");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("REMARK1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("REMARK1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("REMARK1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("REMARK1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("REMARK1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("REMARK1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("REMARK1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("REMARK1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("REMARK1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("REMARK1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("REMARK1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("REMARK1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("REMARK1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("REMARK1 not between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNull() {
            addCriterion("REMARK2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("REMARK2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("REMARK2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            addCriterion("REMARK2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            addCriterion("REMARK2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            addCriterion("REMARK2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(String value) {
            addCriterion("REMARK2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            addCriterion("REMARK2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Like(String value) {
            addCriterion("REMARK2 like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotLike(String value) {
            addCriterion("REMARK2 not like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<String> values) {
            addCriterion("REMARK2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            addCriterion("REMARK2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            addCriterion("REMARK2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            addCriterion("REMARK2 not between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNull() {
            addCriterion("REMARK3 is null");
            return (Criteria) this;
        }

        public Criteria andRemark3IsNotNull() {
            addCriterion("REMARK3 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark3EqualTo(String value) {
            addCriterion("REMARK3 =", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            addCriterion("REMARK3 <>", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            addCriterion("REMARK3 >", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            addCriterion("REMARK3 >=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThan(String value) {
            addCriterion("REMARK3 <", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            addCriterion("REMARK3 <=", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Like(String value) {
            addCriterion("REMARK3 like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotLike(String value) {
            addCriterion("REMARK3 not like", value, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3In(List<String> values) {
            addCriterion("REMARK3 in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            addCriterion("REMARK3 not in", values, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            addCriterion("REMARK3 between", value1, value2, "remark3");
            return (Criteria) this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            addCriterion("REMARK3 not between", value1, value2, "remark3");
            return (Criteria) this;
        }

        public Criteria andTransactionidIsNull() {
            addCriterion("TRANSACTIONID is null");
            return (Criteria) this;
        }

        public Criteria andTransactionidIsNotNull() {
            addCriterion("TRANSACTIONID is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionidEqualTo(String value) {
            addCriterion("TRANSACTIONID =", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidNotEqualTo(String value) {
            addCriterion("TRANSACTIONID <>", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidGreaterThan(String value) {
            addCriterion("TRANSACTIONID >", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSACTIONID >=", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidLessThan(String value) {
            addCriterion("TRANSACTIONID <", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidLessThanOrEqualTo(String value) {
            addCriterion("TRANSACTIONID <=", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidLike(String value) {
            addCriterion("TRANSACTIONID like", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidNotLike(String value) {
            addCriterion("TRANSACTIONID not like", value, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidIn(List<String> values) {
            addCriterion("TRANSACTIONID in", values, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidNotIn(List<String> values) {
            addCriterion("TRANSACTIONID not in", values, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidBetween(String value1, String value2) {
            addCriterion("TRANSACTIONID between", value1, value2, "transactionid");
            return (Criteria) this;
        }

        public Criteria andTransactionidNotBetween(String value1, String value2) {
            addCriterion("TRANSACTIONID not between", value1, value2, "transactionid");
            return (Criteria) this;
        }

        public Criteria andOrderAmtIsNull() {
            addCriterion("ORDER_AMT is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmtIsNotNull() {
            addCriterion("ORDER_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmtEqualTo(BigDecimal value) {
            addCriterion("ORDER_AMT =", value, "orderAmt");
            return (Criteria) this;
        }

        public Criteria andOrderAmtNotEqualTo(BigDecimal value) {
            addCriterion("ORDER_AMT <>", value, "orderAmt");
            return (Criteria) this;
        }

        public Criteria andOrderAmtGreaterThan(BigDecimal value) {
            addCriterion("ORDER_AMT >", value, "orderAmt");
            return (Criteria) this;
        }

        public Criteria andOrderAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_AMT >=", value, "orderAmt");
            return (Criteria) this;
        }

        public Criteria andOrderAmtLessThan(BigDecimal value) {
            addCriterion("ORDER_AMT <", value, "orderAmt");
            return (Criteria) this;
        }

        public Criteria andOrderAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_AMT <=", value, "orderAmt");
            return (Criteria) this;
        }

        public Criteria andOrderAmtIn(List<BigDecimal> values) {
            addCriterion("ORDER_AMT in", values, "orderAmt");
            return (Criteria) this;
        }

        public Criteria andOrderAmtNotIn(List<BigDecimal> values) {
            addCriterion("ORDER_AMT not in", values, "orderAmt");
            return (Criteria) this;
        }

        public Criteria andOrderAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_AMT between", value1, value2, "orderAmt");
            return (Criteria) this;
        }

        public Criteria andOrderAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_AMT not between", value1, value2, "orderAmt");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNull() {
            addCriterion("ORDER_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNotNull() {
            addCriterion("ORDER_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDateEqualTo(String value) {
            addCriterion("ORDER_DATE =", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotEqualTo(String value) {
            addCriterion("ORDER_DATE <>", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThan(String value) {
            addCriterion("ORDER_DATE >", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_DATE >=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThan(String value) {
            addCriterion("ORDER_DATE <", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThanOrEqualTo(String value) {
            addCriterion("ORDER_DATE <=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLike(String value) {
            addCriterion("ORDER_DATE like", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotLike(String value) {
            addCriterion("ORDER_DATE not like", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateIn(List<String> values) {
            addCriterion("ORDER_DATE in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotIn(List<String> values) {
            addCriterion("ORDER_DATE not in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateBetween(String value1, String value2) {
            addCriterion("ORDER_DATE between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotBetween(String value1, String value2) {
            addCriterion("ORDER_DATE not between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkIsNull() {
            addCriterion("VENDER_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkIsNotNull() {
            addCriterion("VENDER_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkEqualTo(String value) {
            addCriterion("VENDER_REMARK =", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkNotEqualTo(String value) {
            addCriterion("VENDER_REMARK <>", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkGreaterThan(String value) {
            addCriterion("VENDER_REMARK >", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("VENDER_REMARK >=", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkLessThan(String value) {
            addCriterion("VENDER_REMARK <", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkLessThanOrEqualTo(String value) {
            addCriterion("VENDER_REMARK <=", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkLike(String value) {
            addCriterion("VENDER_REMARK like", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkNotLike(String value) {
            addCriterion("VENDER_REMARK not like", value, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkIn(List<String> values) {
            addCriterion("VENDER_REMARK in", values, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkNotIn(List<String> values) {
            addCriterion("VENDER_REMARK not in", values, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkBetween(String value1, String value2) {
            addCriterion("VENDER_REMARK between", value1, value2, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andVenderRemarkNotBetween(String value1, String value2) {
            addCriterion("VENDER_REMARK not between", value1, value2, "venderRemark");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("ORDER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("ORDER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("ORDER_TYPE =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("ORDER_TYPE <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("ORDER_TYPE >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_TYPE >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("ORDER_TYPE <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("ORDER_TYPE <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("ORDER_TYPE like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("ORDER_TYPE not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("ORDER_TYPE in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("ORDER_TYPE not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("ORDER_TYPE between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("ORDER_TYPE not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtOldIsNull() {
            addCriterion("ORDER_REAL_AMT_OLD is null");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtOldIsNotNull() {
            addCriterion("ORDER_REAL_AMT_OLD is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtOldEqualTo(BigDecimal value) {
            addCriterion("ORDER_REAL_AMT_OLD =", value, "orderRealAmtOld");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtOldNotEqualTo(BigDecimal value) {
            addCriterion("ORDER_REAL_AMT_OLD <>", value, "orderRealAmtOld");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtOldGreaterThan(BigDecimal value) {
            addCriterion("ORDER_REAL_AMT_OLD >", value, "orderRealAmtOld");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtOldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_REAL_AMT_OLD >=", value, "orderRealAmtOld");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtOldLessThan(BigDecimal value) {
            addCriterion("ORDER_REAL_AMT_OLD <", value, "orderRealAmtOld");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtOldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_REAL_AMT_OLD <=", value, "orderRealAmtOld");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtOldIn(List<BigDecimal> values) {
            addCriterion("ORDER_REAL_AMT_OLD in", values, "orderRealAmtOld");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtOldNotIn(List<BigDecimal> values) {
            addCriterion("ORDER_REAL_AMT_OLD not in", values, "orderRealAmtOld");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtOldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_REAL_AMT_OLD between", value1, value2, "orderRealAmtOld");
            return (Criteria) this;
        }

        public Criteria andOrderRealAmtOldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_REAL_AMT_OLD not between", value1, value2, "orderRealAmtOld");
            return (Criteria) this;
        }

        public Criteria andFreightIsNull() {
            addCriterion("FREIGHT is null");
            return (Criteria) this;
        }

        public Criteria andFreightIsNotNull() {
            addCriterion("FREIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andFreightEqualTo(BigDecimal value) {
            addCriterion("FREIGHT =", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotEqualTo(BigDecimal value) {
            addCriterion("FREIGHT <>", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThan(BigDecimal value) {
            addCriterion("FREIGHT >", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FREIGHT >=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThan(BigDecimal value) {
            addCriterion("FREIGHT <", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FREIGHT <=", value, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightIn(List<BigDecimal> values) {
            addCriterion("FREIGHT in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotIn(List<BigDecimal> values) {
            addCriterion("FREIGHT not in", values, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREIGHT between", value1, value2, "freight");
            return (Criteria) this;
        }

        public Criteria andFreightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREIGHT not between", value1, value2, "freight");
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