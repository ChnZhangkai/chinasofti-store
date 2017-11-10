package com.chinasofti.mall.common.entity.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PyPayorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PyPayorderExample() {
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

        public Criteria andOrderidsIsNull() {
            addCriterion("ORDERIDS is null");
            return (Criteria) this;
        }

        public Criteria andOrderidsIsNotNull() {
            addCriterion("ORDERIDS is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidsEqualTo(String value) {
            addCriterion("ORDERIDS =", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsNotEqualTo(String value) {
            addCriterion("ORDERIDS <>", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsGreaterThan(String value) {
            addCriterion("ORDERIDS >", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsGreaterThanOrEqualTo(String value) {
            addCriterion("ORDERIDS >=", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsLessThan(String value) {
            addCriterion("ORDERIDS <", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsLessThanOrEqualTo(String value) {
            addCriterion("ORDERIDS <=", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsLike(String value) {
            addCriterion("ORDERIDS like", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsNotLike(String value) {
            addCriterion("ORDERIDS not like", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsIn(List<String> values) {
            addCriterion("ORDERIDS in", values, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsNotIn(List<String> values) {
            addCriterion("ORDERIDS not in", values, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsBetween(String value1, String value2) {
            addCriterion("ORDERIDS between", value1, value2, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsNotBetween(String value1, String value2) {
            addCriterion("ORDERIDS not between", value1, value2, "orderids");
            return (Criteria) this;
        }

        public Criteria andPaypriceIsNull() {
            addCriterion("PAYPRICE is null");
            return (Criteria) this;
        }

        public Criteria andPaypriceIsNotNull() {
            addCriterion("PAYPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPaypriceEqualTo(BigDecimal value) {
            addCriterion("PAYPRICE =", value, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceNotEqualTo(BigDecimal value) {
            addCriterion("PAYPRICE <>", value, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceGreaterThan(BigDecimal value) {
            addCriterion("PAYPRICE >", value, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYPRICE >=", value, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceLessThan(BigDecimal value) {
            addCriterion("PAYPRICE <", value, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PAYPRICE <=", value, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceIn(List<BigDecimal> values) {
            addCriterion("PAYPRICE in", values, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceNotIn(List<BigDecimal> values) {
            addCriterion("PAYPRICE not in", values, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYPRICE between", value1, value2, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaypriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAYPRICE not between", value1, value2, "payprice");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNull() {
            addCriterion("PAYTIME is null");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNotNull() {
            addCriterion("PAYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPaytimeEqualTo(String value) {
            addCriterion("PAYTIME =", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotEqualTo(String value) {
            addCriterion("PAYTIME <>", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThan(String value) {
            addCriterion("PAYTIME >", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYTIME >=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThan(String value) {
            addCriterion("PAYTIME <", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThanOrEqualTo(String value) {
            addCriterion("PAYTIME <=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLike(String value) {
            addCriterion("PAYTIME like", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotLike(String value) {
            addCriterion("PAYTIME not like", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeIn(List<String> values) {
            addCriterion("PAYTIME in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotIn(List<String> values) {
            addCriterion("PAYTIME not in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeBetween(String value1, String value2) {
            addCriterion("PAYTIME between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotBetween(String value1, String value2) {
            addCriterion("PAYTIME not between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("USERID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("USERID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andPaystatusIsNull() {
            addCriterion("PAYSTATUS is null");
            return (Criteria) this;
        }

        public Criteria andPaystatusIsNotNull() {
            addCriterion("PAYSTATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPaystatusEqualTo(String value) {
            addCriterion("PAYSTATUS =", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotEqualTo(String value) {
            addCriterion("PAYSTATUS <>", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusGreaterThan(String value) {
            addCriterion("PAYSTATUS >", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusGreaterThanOrEqualTo(String value) {
            addCriterion("PAYSTATUS >=", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLessThan(String value) {
            addCriterion("PAYSTATUS <", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLessThanOrEqualTo(String value) {
            addCriterion("PAYSTATUS <=", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLike(String value) {
            addCriterion("PAYSTATUS like", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotLike(String value) {
            addCriterion("PAYSTATUS not like", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusIn(List<String> values) {
            addCriterion("PAYSTATUS in", values, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotIn(List<String> values) {
            addCriterion("PAYSTATUS not in", values, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusBetween(String value1, String value2) {
            addCriterion("PAYSTATUS between", value1, value2, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotBetween(String value1, String value2) {
            addCriterion("PAYSTATUS not between", value1, value2, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaychannelIsNull() {
            addCriterion("PAYCHANNEL is null");
            return (Criteria) this;
        }

        public Criteria andPaychannelIsNotNull() {
            addCriterion("PAYCHANNEL is not null");
            return (Criteria) this;
        }

        public Criteria andPaychannelEqualTo(String value) {
            addCriterion("PAYCHANNEL =", value, "paychannel");
            return (Criteria) this;
        }

        public Criteria andPaychannelNotEqualTo(String value) {
            addCriterion("PAYCHANNEL <>", value, "paychannel");
            return (Criteria) this;
        }

        public Criteria andPaychannelGreaterThan(String value) {
            addCriterion("PAYCHANNEL >", value, "paychannel");
            return (Criteria) this;
        }

        public Criteria andPaychannelGreaterThanOrEqualTo(String value) {
            addCriterion("PAYCHANNEL >=", value, "paychannel");
            return (Criteria) this;
        }

        public Criteria andPaychannelLessThan(String value) {
            addCriterion("PAYCHANNEL <", value, "paychannel");
            return (Criteria) this;
        }

        public Criteria andPaychannelLessThanOrEqualTo(String value) {
            addCriterion("PAYCHANNEL <=", value, "paychannel");
            return (Criteria) this;
        }

        public Criteria andPaychannelLike(String value) {
            addCriterion("PAYCHANNEL like", value, "paychannel");
            return (Criteria) this;
        }

        public Criteria andPaychannelNotLike(String value) {
            addCriterion("PAYCHANNEL not like", value, "paychannel");
            return (Criteria) this;
        }

        public Criteria andPaychannelIn(List<String> values) {
            addCriterion("PAYCHANNEL in", values, "paychannel");
            return (Criteria) this;
        }

        public Criteria andPaychannelNotIn(List<String> values) {
            addCriterion("PAYCHANNEL not in", values, "paychannel");
            return (Criteria) this;
        }

        public Criteria andPaychannelBetween(String value1, String value2) {
            addCriterion("PAYCHANNEL between", value1, value2, "paychannel");
            return (Criteria) this;
        }

        public Criteria andPaychannelNotBetween(String value1, String value2) {
            addCriterion("PAYCHANNEL not between", value1, value2, "paychannel");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeIsNull() {
            addCriterion("PAYFINISHTIME is null");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeIsNotNull() {
            addCriterion("PAYFINISHTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeEqualTo(String value) {
            addCriterion("PAYFINISHTIME =", value, "payfinishtime");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeNotEqualTo(String value) {
            addCriterion("PAYFINISHTIME <>", value, "payfinishtime");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeGreaterThan(String value) {
            addCriterion("PAYFINISHTIME >", value, "payfinishtime");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeGreaterThanOrEqualTo(String value) {
            addCriterion("PAYFINISHTIME >=", value, "payfinishtime");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeLessThan(String value) {
            addCriterion("PAYFINISHTIME <", value, "payfinishtime");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeLessThanOrEqualTo(String value) {
            addCriterion("PAYFINISHTIME <=", value, "payfinishtime");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeLike(String value) {
            addCriterion("PAYFINISHTIME like", value, "payfinishtime");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeNotLike(String value) {
            addCriterion("PAYFINISHTIME not like", value, "payfinishtime");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeIn(List<String> values) {
            addCriterion("PAYFINISHTIME in", values, "payfinishtime");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeNotIn(List<String> values) {
            addCriterion("PAYFINISHTIME not in", values, "payfinishtime");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeBetween(String value1, String value2) {
            addCriterion("PAYFINISHTIME between", value1, value2, "payfinishtime");
            return (Criteria) this;
        }

        public Criteria andPayfinishtimeNotBetween(String value1, String value2) {
            addCriterion("PAYFINISHTIME not between", value1, value2, "payfinishtime");
            return (Criteria) this;
        }

        public Criteria andChannelorderidIsNull() {
            addCriterion("CHANNELORDERID is null");
            return (Criteria) this;
        }

        public Criteria andChannelorderidIsNotNull() {
            addCriterion("CHANNELORDERID is not null");
            return (Criteria) this;
        }

        public Criteria andChannelorderidEqualTo(String value) {
            addCriterion("CHANNELORDERID =", value, "channelorderid");
            return (Criteria) this;
        }

        public Criteria andChannelorderidNotEqualTo(String value) {
            addCriterion("CHANNELORDERID <>", value, "channelorderid");
            return (Criteria) this;
        }

        public Criteria andChannelorderidGreaterThan(String value) {
            addCriterion("CHANNELORDERID >", value, "channelorderid");
            return (Criteria) this;
        }

        public Criteria andChannelorderidGreaterThanOrEqualTo(String value) {
            addCriterion("CHANNELORDERID >=", value, "channelorderid");
            return (Criteria) this;
        }

        public Criteria andChannelorderidLessThan(String value) {
            addCriterion("CHANNELORDERID <", value, "channelorderid");
            return (Criteria) this;
        }

        public Criteria andChannelorderidLessThanOrEqualTo(String value) {
            addCriterion("CHANNELORDERID <=", value, "channelorderid");
            return (Criteria) this;
        }

        public Criteria andChannelorderidLike(String value) {
            addCriterion("CHANNELORDERID like", value, "channelorderid");
            return (Criteria) this;
        }

        public Criteria andChannelorderidNotLike(String value) {
            addCriterion("CHANNELORDERID not like", value, "channelorderid");
            return (Criteria) this;
        }

        public Criteria andChannelorderidIn(List<String> values) {
            addCriterion("CHANNELORDERID in", values, "channelorderid");
            return (Criteria) this;
        }

        public Criteria andChannelorderidNotIn(List<String> values) {
            addCriterion("CHANNELORDERID not in", values, "channelorderid");
            return (Criteria) this;
        }

        public Criteria andChannelorderidBetween(String value1, String value2) {
            addCriterion("CHANNELORDERID between", value1, value2, "channelorderid");
            return (Criteria) this;
        }

        public Criteria andChannelorderidNotBetween(String value1, String value2) {
            addCriterion("CHANNELORDERID not between", value1, value2, "channelorderid");
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