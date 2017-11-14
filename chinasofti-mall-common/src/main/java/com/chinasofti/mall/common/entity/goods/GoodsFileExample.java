package com.chinasofti.mall.common.entity.goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsFileExample() {
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

        public Criteria andFilepathIsNull() {
            addCriterion("FILEPATH is null");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNotNull() {
            addCriterion("FILEPATH is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathEqualTo(String value) {
            addCriterion("FILEPATH =", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotEqualTo(String value) {
            addCriterion("FILEPATH <>", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThan(String value) {
            addCriterion("FILEPATH >", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("FILEPATH >=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThan(String value) {
            addCriterion("FILEPATH <", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThanOrEqualTo(String value) {
            addCriterion("FILEPATH <=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLike(String value) {
            addCriterion("FILEPATH like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotLike(String value) {
            addCriterion("FILEPATH not like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathIn(List<String> values) {
            addCriterion("FILEPATH in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotIn(List<String> values) {
            addCriterion("FILEPATH not in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathBetween(String value1, String value2) {
            addCriterion("FILEPATH between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotBetween(String value1, String value2) {
            addCriterion("FILEPATH not between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("FILENAME is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("FILENAME is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("FILENAME =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("FILENAME <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("FILENAME >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("FILENAME >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("FILENAME <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("FILENAME <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("FILENAME like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("FILENAME not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("FILENAME in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("FILENAME not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("FILENAME between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("FILENAME not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFiletypeIsNull() {
            addCriterion("FILETYPE is null");
            return (Criteria) this;
        }

        public Criteria andFiletypeIsNotNull() {
            addCriterion("FILETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFiletypeEqualTo(String value) {
            addCriterion("FILETYPE =", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotEqualTo(String value) {
            addCriterion("FILETYPE <>", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeGreaterThan(String value) {
            addCriterion("FILETYPE >", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeGreaterThanOrEqualTo(String value) {
            addCriterion("FILETYPE >=", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLessThan(String value) {
            addCriterion("FILETYPE <", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLessThanOrEqualTo(String value) {
            addCriterion("FILETYPE <=", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLike(String value) {
            addCriterion("FILETYPE like", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotLike(String value) {
            addCriterion("FILETYPE not like", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeIn(List<String> values) {
            addCriterion("FILETYPE in", values, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotIn(List<String> values) {
            addCriterion("FILETYPE not in", values, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeBetween(String value1, String value2) {
            addCriterion("FILETYPE between", value1, value2, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotBetween(String value1, String value2) {
            addCriterion("FILETYPE not between", value1, value2, "filetype");
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