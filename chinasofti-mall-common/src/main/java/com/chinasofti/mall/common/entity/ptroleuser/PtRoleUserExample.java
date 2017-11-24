package com.chinasofti.mall.common.entity.ptroleuser;

import java.util.ArrayList;
import java.util.List;

public class PtRoleUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PtRoleUserExample() {
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

        public Criteria andRoleIdsIsNull() {
            addCriterion("ROLE_IDS is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdsIsNotNull() {
            addCriterion("ROLE_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdsEqualTo(String value) {
            addCriterion("ROLE_IDS =", value, "roleIds");
            return (Criteria) this;
        }

        public Criteria andRoleIdsNotEqualTo(String value) {
            addCriterion("ROLE_IDS <>", value, "roleIds");
            return (Criteria) this;
        }

        public Criteria andRoleIdsGreaterThan(String value) {
            addCriterion("ROLE_IDS >", value, "roleIds");
            return (Criteria) this;
        }

        public Criteria andRoleIdsGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_IDS >=", value, "roleIds");
            return (Criteria) this;
        }

        public Criteria andRoleIdsLessThan(String value) {
            addCriterion("ROLE_IDS <", value, "roleIds");
            return (Criteria) this;
        }

        public Criteria andRoleIdsLessThanOrEqualTo(String value) {
            addCriterion("ROLE_IDS <=", value, "roleIds");
            return (Criteria) this;
        }

        public Criteria andRoleIdsLike(String value) {
            addCriterion("ROLE_IDS like", value, "roleIds");
            return (Criteria) this;
        }

        public Criteria andRoleIdsNotLike(String value) {
            addCriterion("ROLE_IDS not like", value, "roleIds");
            return (Criteria) this;
        }

        public Criteria andRoleIdsIn(List<String> values) {
            addCriterion("ROLE_IDS in", values, "roleIds");
            return (Criteria) this;
        }

        public Criteria andRoleIdsNotIn(List<String> values) {
            addCriterion("ROLE_IDS not in", values, "roleIds");
            return (Criteria) this;
        }

        public Criteria andRoleIdsBetween(String value1, String value2) {
            addCriterion("ROLE_IDS between", value1, value2, "roleIds");
            return (Criteria) this;
        }

        public Criteria andRoleIdsNotBetween(String value1, String value2) {
            addCriterion("ROLE_IDS not between", value1, value2, "roleIds");
            return (Criteria) this;
        }

        public Criteria andModuleIdsIsNull() {
            addCriterion("MODULE_IDS is null");
            return (Criteria) this;
        }

        public Criteria andModuleIdsIsNotNull() {
            addCriterion("MODULE_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andModuleIdsEqualTo(String value) {
            addCriterion("MODULE_IDS =", value, "moduleIds");
            return (Criteria) this;
        }

        public Criteria andModuleIdsNotEqualTo(String value) {
            addCriterion("MODULE_IDS <>", value, "moduleIds");
            return (Criteria) this;
        }

        public Criteria andModuleIdsGreaterThan(String value) {
            addCriterion("MODULE_IDS >", value, "moduleIds");
            return (Criteria) this;
        }

        public Criteria andModuleIdsGreaterThanOrEqualTo(String value) {
            addCriterion("MODULE_IDS >=", value, "moduleIds");
            return (Criteria) this;
        }

        public Criteria andModuleIdsLessThan(String value) {
            addCriterion("MODULE_IDS <", value, "moduleIds");
            return (Criteria) this;
        }

        public Criteria andModuleIdsLessThanOrEqualTo(String value) {
            addCriterion("MODULE_IDS <=", value, "moduleIds");
            return (Criteria) this;
        }

        public Criteria andModuleIdsLike(String value) {
            addCriterion("MODULE_IDS like", value, "moduleIds");
            return (Criteria) this;
        }

        public Criteria andModuleIdsNotLike(String value) {
            addCriterion("MODULE_IDS not like", value, "moduleIds");
            return (Criteria) this;
        }

        public Criteria andModuleIdsIn(List<String> values) {
            addCriterion("MODULE_IDS in", values, "moduleIds");
            return (Criteria) this;
        }

        public Criteria andModuleIdsNotIn(List<String> values) {
            addCriterion("MODULE_IDS not in", values, "moduleIds");
            return (Criteria) this;
        }

        public Criteria andModuleIdsBetween(String value1, String value2) {
            addCriterion("MODULE_IDS between", value1, value2, "moduleIds");
            return (Criteria) this;
        }

        public Criteria andModuleIdsNotBetween(String value1, String value2) {
            addCriterion("MODULE_IDS not between", value1, value2, "moduleIds");
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