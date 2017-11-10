package com.chinasofti.mall.common.entity.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PyBigGoodsorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PyBigGoodsorderExample() {
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

        public Criteria andOrderTotalAmtIsNull() {
            addCriterion("ORDER_TOTAL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmtIsNotNull() {
            addCriterion("ORDER_TOTAL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmtEqualTo(BigDecimal value) {
            addCriterion("ORDER_TOTAL_AMT =", value, "orderTotalAmt");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmtNotEqualTo(BigDecimal value) {
            addCriterion("ORDER_TOTAL_AMT <>", value, "orderTotalAmt");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmtGreaterThan(BigDecimal value) {
            addCriterion("ORDER_TOTAL_AMT >", value, "orderTotalAmt");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_TOTAL_AMT >=", value, "orderTotalAmt");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmtLessThan(BigDecimal value) {
            addCriterion("ORDER_TOTAL_AMT <", value, "orderTotalAmt");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDER_TOTAL_AMT <=", value, "orderTotalAmt");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmtIn(List<BigDecimal> values) {
            addCriterion("ORDER_TOTAL_AMT in", values, "orderTotalAmt");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmtNotIn(List<BigDecimal> values) {
            addCriterion("ORDER_TOTAL_AMT not in", values, "orderTotalAmt");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_TOTAL_AMT between", value1, value2, "orderTotalAmt");
            return (Criteria) this;
        }

        public Criteria andOrderTotalAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDER_TOTAL_AMT not between", value1, value2, "orderTotalAmt");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalAmtIsNull() {
            addCriterion("GOODS_TOTAL_AMT is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalAmtIsNotNull() {
            addCriterion("GOODS_TOTAL_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalAmtEqualTo(BigDecimal value) {
            addCriterion("GOODS_TOTAL_AMT =", value, "goodsTotalAmt");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalAmtNotEqualTo(BigDecimal value) {
            addCriterion("GOODS_TOTAL_AMT <>", value, "goodsTotalAmt");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalAmtGreaterThan(BigDecimal value) {
            addCriterion("GOODS_TOTAL_AMT >", value, "goodsTotalAmt");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_TOTAL_AMT >=", value, "goodsTotalAmt");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalAmtLessThan(BigDecimal value) {
            addCriterion("GOODS_TOTAL_AMT <", value, "goodsTotalAmt");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_TOTAL_AMT <=", value, "goodsTotalAmt");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalAmtIn(List<BigDecimal> values) {
            addCriterion("GOODS_TOTAL_AMT in", values, "goodsTotalAmt");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalAmtNotIn(List<BigDecimal> values) {
            addCriterion("GOODS_TOTAL_AMT not in", values, "goodsTotalAmt");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_TOTAL_AMT between", value1, value2, "goodsTotalAmt");
            return (Criteria) this;
        }

        public Criteria andGoodsTotalAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_TOTAL_AMT not between", value1, value2, "goodsTotalAmt");
            return (Criteria) this;
        }

        public Criteria andUserIdsIsNull() {
            addCriterion("USER_IDS is null");
            return (Criteria) this;
        }

        public Criteria andUserIdsIsNotNull() {
            addCriterion("USER_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdsEqualTo(String value) {
            addCriterion("USER_IDS =", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsNotEqualTo(String value) {
            addCriterion("USER_IDS <>", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsGreaterThan(String value) {
            addCriterion("USER_IDS >", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsGreaterThanOrEqualTo(String value) {
            addCriterion("USER_IDS >=", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsLessThan(String value) {
            addCriterion("USER_IDS <", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsLessThanOrEqualTo(String value) {
            addCriterion("USER_IDS <=", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsLike(String value) {
            addCriterion("USER_IDS like", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsNotLike(String value) {
            addCriterion("USER_IDS not like", value, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsIn(List<String> values) {
            addCriterion("USER_IDS in", values, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsNotIn(List<String> values) {
            addCriterion("USER_IDS not in", values, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsBetween(String value1, String value2) {
            addCriterion("USER_IDS between", value1, value2, "userIds");
            return (Criteria) this;
        }

        public Criteria andUserIdsNotBetween(String value1, String value2) {
            addCriterion("USER_IDS not between", value1, value2, "userIds");
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

        public Criteria andPaywayIsNull() {
            addCriterion("PAYWAY is null");
            return (Criteria) this;
        }

        public Criteria andPaywayIsNotNull() {
            addCriterion("PAYWAY is not null");
            return (Criteria) this;
        }

        public Criteria andPaywayEqualTo(String value) {
            addCriterion("PAYWAY =", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayNotEqualTo(String value) {
            addCriterion("PAYWAY <>", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayGreaterThan(String value) {
            addCriterion("PAYWAY >", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayGreaterThanOrEqualTo(String value) {
            addCriterion("PAYWAY >=", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayLessThan(String value) {
            addCriterion("PAYWAY <", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayLessThanOrEqualTo(String value) {
            addCriterion("PAYWAY <=", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayLike(String value) {
            addCriterion("PAYWAY like", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayNotLike(String value) {
            addCriterion("PAYWAY not like", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayIn(List<String> values) {
            addCriterion("PAYWAY in", values, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayNotIn(List<String> values) {
            addCriterion("PAYWAY not in", values, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayBetween(String value1, String value2) {
            addCriterion("PAYWAY between", value1, value2, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayNotBetween(String value1, String value2) {
            addCriterion("PAYWAY not between", value1, value2, "payway");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("PAY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("PAY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(String value) {
            addCriterion("PAY_STATUS =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(String value) {
            addCriterion("PAY_STATUS <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(String value) {
            addCriterion("PAY_STATUS >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_STATUS >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(String value) {
            addCriterion("PAY_STATUS <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(String value) {
            addCriterion("PAY_STATUS <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLike(String value) {
            addCriterion("PAY_STATUS like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotLike(String value) {
            addCriterion("PAY_STATUS not like", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<String> values) {
            addCriterion("PAY_STATUS in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<String> values) {
            addCriterion("PAY_STATUS not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(String value1, String value2) {
            addCriterion("PAY_STATUS between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(String value1, String value2) {
            addCriterion("PAY_STATUS not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusIsNull() {
            addCriterion("CHECKING_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusIsNotNull() {
            addCriterion("CHECKING_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusEqualTo(String value) {
            addCriterion("CHECKING_STATUS =", value, "checkingStatus");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusNotEqualTo(String value) {
            addCriterion("CHECKING_STATUS <>", value, "checkingStatus");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusGreaterThan(String value) {
            addCriterion("CHECKING_STATUS >", value, "checkingStatus");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKING_STATUS >=", value, "checkingStatus");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusLessThan(String value) {
            addCriterion("CHECKING_STATUS <", value, "checkingStatus");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusLessThanOrEqualTo(String value) {
            addCriterion("CHECKING_STATUS <=", value, "checkingStatus");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusLike(String value) {
            addCriterion("CHECKING_STATUS like", value, "checkingStatus");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusNotLike(String value) {
            addCriterion("CHECKING_STATUS not like", value, "checkingStatus");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusIn(List<String> values) {
            addCriterion("CHECKING_STATUS in", values, "checkingStatus");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusNotIn(List<String> values) {
            addCriterion("CHECKING_STATUS not in", values, "checkingStatus");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusBetween(String value1, String value2) {
            addCriterion("CHECKING_STATUS between", value1, value2, "checkingStatus");
            return (Criteria) this;
        }

        public Criteria andCheckingStatusNotBetween(String value1, String value2) {
            addCriterion("CHECKING_STATUS not between", value1, value2, "checkingStatus");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNull() {
            addCriterion("CHECK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNotNull() {
            addCriterion("CHECK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateEqualTo(String value) {
            addCriterion("CHECK_DATE =", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotEqualTo(String value) {
            addCriterion("CHECK_DATE <>", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThan(String value) {
            addCriterion("CHECK_DATE >", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_DATE >=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThan(String value) {
            addCriterion("CHECK_DATE <", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThanOrEqualTo(String value) {
            addCriterion("CHECK_DATE <=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLike(String value) {
            addCriterion("CHECK_DATE like", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotLike(String value) {
            addCriterion("CHECK_DATE not like", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIn(List<String> values) {
            addCriterion("CHECK_DATE in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotIn(List<String> values) {
            addCriterion("CHECK_DATE not in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateBetween(String value1, String value2) {
            addCriterion("CHECK_DATE between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotBetween(String value1, String value2) {
            addCriterion("CHECK_DATE not between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoIsNull() {
            addCriterion("CHECK_BATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoIsNotNull() {
            addCriterion("CHECK_BATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoEqualTo(String value) {
            addCriterion("CHECK_BATCH_NO =", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoNotEqualTo(String value) {
            addCriterion("CHECK_BATCH_NO <>", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoGreaterThan(String value) {
            addCriterion("CHECK_BATCH_NO >", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_BATCH_NO >=", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoLessThan(String value) {
            addCriterion("CHECK_BATCH_NO <", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoLessThanOrEqualTo(String value) {
            addCriterion("CHECK_BATCH_NO <=", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoLike(String value) {
            addCriterion("CHECK_BATCH_NO like", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoNotLike(String value) {
            addCriterion("CHECK_BATCH_NO not like", value, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoIn(List<String> values) {
            addCriterion("CHECK_BATCH_NO in", values, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoNotIn(List<String> values) {
            addCriterion("CHECK_BATCH_NO not in", values, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoBetween(String value1, String value2) {
            addCriterion("CHECK_BATCH_NO between", value1, value2, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andCheckBatchNoNotBetween(String value1, String value2) {
            addCriterion("CHECK_BATCH_NO not between", value1, value2, "checkBatchNo");
            return (Criteria) this;
        }

        public Criteria andWxFeeIsNull() {
            addCriterion("WX_FEE is null");
            return (Criteria) this;
        }

        public Criteria andWxFeeIsNotNull() {
            addCriterion("WX_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andWxFeeEqualTo(BigDecimal value) {
            addCriterion("WX_FEE =", value, "wxFee");
            return (Criteria) this;
        }

        public Criteria andWxFeeNotEqualTo(BigDecimal value) {
            addCriterion("WX_FEE <>", value, "wxFee");
            return (Criteria) this;
        }

        public Criteria andWxFeeGreaterThan(BigDecimal value) {
            addCriterion("WX_FEE >", value, "wxFee");
            return (Criteria) this;
        }

        public Criteria andWxFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WX_FEE >=", value, "wxFee");
            return (Criteria) this;
        }

        public Criteria andWxFeeLessThan(BigDecimal value) {
            addCriterion("WX_FEE <", value, "wxFee");
            return (Criteria) this;
        }

        public Criteria andWxFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WX_FEE <=", value, "wxFee");
            return (Criteria) this;
        }

        public Criteria andWxFeeIn(List<BigDecimal> values) {
            addCriterion("WX_FEE in", values, "wxFee");
            return (Criteria) this;
        }

        public Criteria andWxFeeNotIn(List<BigDecimal> values) {
            addCriterion("WX_FEE not in", values, "wxFee");
            return (Criteria) this;
        }

        public Criteria andWxFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WX_FEE between", value1, value2, "wxFee");
            return (Criteria) this;
        }

        public Criteria andWxFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WX_FEE not between", value1, value2, "wxFee");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("PAY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("PAY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(String value) {
            addCriterion("PAY_TIME =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(String value) {
            addCriterion("PAY_TIME <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(String value) {
            addCriterion("PAY_TIME >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_TIME >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(String value) {
            addCriterion("PAY_TIME <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(String value) {
            addCriterion("PAY_TIME <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLike(String value) {
            addCriterion("PAY_TIME like", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotLike(String value) {
            addCriterion("PAY_TIME not like", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<String> values) {
            addCriterion("PAY_TIME in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<String> values) {
            addCriterion("PAY_TIME not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(String value1, String value2) {
            addCriterion("PAY_TIME between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(String value1, String value2) {
            addCriterion("PAY_TIME not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andIsTicketIsNull() {
            addCriterion("IS_TICKET is null");
            return (Criteria) this;
        }

        public Criteria andIsTicketIsNotNull() {
            addCriterion("IS_TICKET is not null");
            return (Criteria) this;
        }

        public Criteria andIsTicketEqualTo(String value) {
            addCriterion("IS_TICKET =", value, "isTicket");
            return (Criteria) this;
        }

        public Criteria andIsTicketNotEqualTo(String value) {
            addCriterion("IS_TICKET <>", value, "isTicket");
            return (Criteria) this;
        }

        public Criteria andIsTicketGreaterThan(String value) {
            addCriterion("IS_TICKET >", value, "isTicket");
            return (Criteria) this;
        }

        public Criteria andIsTicketGreaterThanOrEqualTo(String value) {
            addCriterion("IS_TICKET >=", value, "isTicket");
            return (Criteria) this;
        }

        public Criteria andIsTicketLessThan(String value) {
            addCriterion("IS_TICKET <", value, "isTicket");
            return (Criteria) this;
        }

        public Criteria andIsTicketLessThanOrEqualTo(String value) {
            addCriterion("IS_TICKET <=", value, "isTicket");
            return (Criteria) this;
        }

        public Criteria andIsTicketLike(String value) {
            addCriterion("IS_TICKET like", value, "isTicket");
            return (Criteria) this;
        }

        public Criteria andIsTicketNotLike(String value) {
            addCriterion("IS_TICKET not like", value, "isTicket");
            return (Criteria) this;
        }

        public Criteria andIsTicketIn(List<String> values) {
            addCriterion("IS_TICKET in", values, "isTicket");
            return (Criteria) this;
        }

        public Criteria andIsTicketNotIn(List<String> values) {
            addCriterion("IS_TICKET not in", values, "isTicket");
            return (Criteria) this;
        }

        public Criteria andIsTicketBetween(String value1, String value2) {
            addCriterion("IS_TICKET between", value1, value2, "isTicket");
            return (Criteria) this;
        }

        public Criteria andIsTicketNotBetween(String value1, String value2) {
            addCriterion("IS_TICKET not between", value1, value2, "isTicket");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("INVOICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("INVOICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeEqualTo(String value) {
            addCriterion("INVOICE_TYPE =", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotEqualTo(String value) {
            addCriterion("INVOICE_TYPE <>", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThan(String value) {
            addCriterion("INVOICE_TYPE >", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICE_TYPE >=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThan(String value) {
            addCriterion("INVOICE_TYPE <", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(String value) {
            addCriterion("INVOICE_TYPE <=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLike(String value) {
            addCriterion("INVOICE_TYPE like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotLike(String value) {
            addCriterion("INVOICE_TYPE not like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIn(List<String> values) {
            addCriterion("INVOICE_TYPE in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotIn(List<String> values) {
            addCriterion("INVOICE_TYPE not in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeBetween(String value1, String value2) {
            addCriterion("INVOICE_TYPE between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotBetween(String value1, String value2) {
            addCriterion("INVOICE_TYPE not between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNull() {
            addCriterion("INVOICE_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNotNull() {
            addCriterion("INVOICE_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleEqualTo(String value) {
            addCriterion("INVOICE_TITLE =", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotEqualTo(String value) {
            addCriterion("INVOICE_TITLE <>", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThan(String value) {
            addCriterion("INVOICE_TITLE >", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICE_TITLE >=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThan(String value) {
            addCriterion("INVOICE_TITLE <", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThanOrEqualTo(String value) {
            addCriterion("INVOICE_TITLE <=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLike(String value) {
            addCriterion("INVOICE_TITLE like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotLike(String value) {
            addCriterion("INVOICE_TITLE not like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIn(List<String> values) {
            addCriterion("INVOICE_TITLE in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotIn(List<String> values) {
            addCriterion("INVOICE_TITLE not in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleBetween(String value1, String value2) {
            addCriterion("INVOICE_TITLE between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotBetween(String value1, String value2) {
            addCriterion("INVOICE_TITLE not between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressIsNull() {
            addCriterion("INVOICE_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressIsNotNull() {
            addCriterion("INVOICE_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressEqualTo(String value) {
            addCriterion("INVOICE_ADDRESS =", value, "invoiceAddress");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressNotEqualTo(String value) {
            addCriterion("INVOICE_ADDRESS <>", value, "invoiceAddress");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressGreaterThan(String value) {
            addCriterion("INVOICE_ADDRESS >", value, "invoiceAddress");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressGreaterThanOrEqualTo(String value) {
            addCriterion("INVOICE_ADDRESS >=", value, "invoiceAddress");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressLessThan(String value) {
            addCriterion("INVOICE_ADDRESS <", value, "invoiceAddress");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressLessThanOrEqualTo(String value) {
            addCriterion("INVOICE_ADDRESS <=", value, "invoiceAddress");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressLike(String value) {
            addCriterion("INVOICE_ADDRESS like", value, "invoiceAddress");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressNotLike(String value) {
            addCriterion("INVOICE_ADDRESS not like", value, "invoiceAddress");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressIn(List<String> values) {
            addCriterion("INVOICE_ADDRESS in", values, "invoiceAddress");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressNotIn(List<String> values) {
            addCriterion("INVOICE_ADDRESS not in", values, "invoiceAddress");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressBetween(String value1, String value2) {
            addCriterion("INVOICE_ADDRESS between", value1, value2, "invoiceAddress");
            return (Criteria) this;
        }

        public Criteria andInvoiceAddressNotBetween(String value1, String value2) {
            addCriterion("INVOICE_ADDRESS not between", value1, value2, "invoiceAddress");
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