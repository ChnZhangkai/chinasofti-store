package com.chinasofti.mall.common.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PtUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PtUserExample() {
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

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(BigDecimal value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(BigDecimal value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(BigDecimal value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(BigDecimal value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<BigDecimal> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<BigDecimal> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andErrorcountIsNull() {
            addCriterion("ERRORCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andErrorcountIsNotNull() {
            addCriterion("ERRORCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andErrorcountEqualTo(BigDecimal value) {
            addCriterion("ERRORCOUNT =", value, "errorcount");
            return (Criteria) this;
        }

        public Criteria andErrorcountNotEqualTo(BigDecimal value) {
            addCriterion("ERRORCOUNT <>", value, "errorcount");
            return (Criteria) this;
        }

        public Criteria andErrorcountGreaterThan(BigDecimal value) {
            addCriterion("ERRORCOUNT >", value, "errorcount");
            return (Criteria) this;
        }

        public Criteria andErrorcountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ERRORCOUNT >=", value, "errorcount");
            return (Criteria) this;
        }

        public Criteria andErrorcountLessThan(BigDecimal value) {
            addCriterion("ERRORCOUNT <", value, "errorcount");
            return (Criteria) this;
        }

        public Criteria andErrorcountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ERRORCOUNT <=", value, "errorcount");
            return (Criteria) this;
        }

        public Criteria andErrorcountIn(List<BigDecimal> values) {
            addCriterion("ERRORCOUNT in", values, "errorcount");
            return (Criteria) this;
        }

        public Criteria andErrorcountNotIn(List<BigDecimal> values) {
            addCriterion("ERRORCOUNT not in", values, "errorcount");
            return (Criteria) this;
        }

        public Criteria andErrorcountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ERRORCOUNT between", value1, value2, "errorcount");
            return (Criteria) this;
        }

        public Criteria andErrorcountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ERRORCOUNT not between", value1, value2, "errorcount");
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

        public Criteria andOrderidsEqualTo(BigDecimal value) {
            addCriterion("ORDERIDS =", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsNotEqualTo(BigDecimal value) {
            addCriterion("ORDERIDS <>", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsGreaterThan(BigDecimal value) {
            addCriterion("ORDERIDS >", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDERIDS >=", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsLessThan(BigDecimal value) {
            addCriterion("ORDERIDS <", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ORDERIDS <=", value, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsIn(List<BigDecimal> values) {
            addCriterion("ORDERIDS in", values, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsNotIn(List<BigDecimal> values) {
            addCriterion("ORDERIDS not in", values, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDERIDS between", value1, value2, "orderids");
            return (Criteria) this;
        }

        public Criteria andOrderidsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ORDERIDS not between", value1, value2, "orderids");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
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

        public Criteria andStopdateIsNull() {
            addCriterion("STOPDATE is null");
            return (Criteria) this;
        }

        public Criteria andStopdateIsNotNull() {
            addCriterion("STOPDATE is not null");
            return (Criteria) this;
        }

        public Criteria andStopdateEqualTo(String value) {
            addCriterion("STOPDATE =", value, "stopdate");
            return (Criteria) this;
        }

        public Criteria andStopdateNotEqualTo(String value) {
            addCriterion("STOPDATE <>", value, "stopdate");
            return (Criteria) this;
        }

        public Criteria andStopdateGreaterThan(String value) {
            addCriterion("STOPDATE >", value, "stopdate");
            return (Criteria) this;
        }

        public Criteria andStopdateGreaterThanOrEqualTo(String value) {
            addCriterion("STOPDATE >=", value, "stopdate");
            return (Criteria) this;
        }

        public Criteria andStopdateLessThan(String value) {
            addCriterion("STOPDATE <", value, "stopdate");
            return (Criteria) this;
        }

        public Criteria andStopdateLessThanOrEqualTo(String value) {
            addCriterion("STOPDATE <=", value, "stopdate");
            return (Criteria) this;
        }

        public Criteria andStopdateLike(String value) {
            addCriterion("STOPDATE like", value, "stopdate");
            return (Criteria) this;
        }

        public Criteria andStopdateNotLike(String value) {
            addCriterion("STOPDATE not like", value, "stopdate");
            return (Criteria) this;
        }

        public Criteria andStopdateIn(List<String> values) {
            addCriterion("STOPDATE in", values, "stopdate");
            return (Criteria) this;
        }

        public Criteria andStopdateNotIn(List<String> values) {
            addCriterion("STOPDATE not in", values, "stopdate");
            return (Criteria) this;
        }

        public Criteria andStopdateBetween(String value1, String value2) {
            addCriterion("STOPDATE between", value1, value2, "stopdate");
            return (Criteria) this;
        }

        public Criteria andStopdateNotBetween(String value1, String value2) {
            addCriterion("STOPDATE not between", value1, value2, "stopdate");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsIsNull() {
            addCriterion("DEPARTMENTIDS is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsIsNotNull() {
            addCriterion("DEPARTMENTIDS is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsEqualTo(String value) {
            addCriterion("DEPARTMENTIDS =", value, "departmentids");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsNotEqualTo(String value) {
            addCriterion("DEPARTMENTIDS <>", value, "departmentids");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsGreaterThan(String value) {
            addCriterion("DEPARTMENTIDS >", value, "departmentids");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsGreaterThanOrEqualTo(String value) {
            addCriterion("DEPARTMENTIDS >=", value, "departmentids");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsLessThan(String value) {
            addCriterion("DEPARTMENTIDS <", value, "departmentids");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsLessThanOrEqualTo(String value) {
            addCriterion("DEPARTMENTIDS <=", value, "departmentids");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsLike(String value) {
            addCriterion("DEPARTMENTIDS like", value, "departmentids");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsNotLike(String value) {
            addCriterion("DEPARTMENTIDS not like", value, "departmentids");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsIn(List<String> values) {
            addCriterion("DEPARTMENTIDS in", values, "departmentids");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsNotIn(List<String> values) {
            addCriterion("DEPARTMENTIDS not in", values, "departmentids");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsBetween(String value1, String value2) {
            addCriterion("DEPARTMENTIDS between", value1, value2, "departmentids");
            return (Criteria) this;
        }

        public Criteria andDepartmentidsNotBetween(String value1, String value2) {
            addCriterion("DEPARTMENTIDS not between", value1, value2, "departmentids");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsIsNull() {
            addCriterion("USERINFOIDS is null");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsIsNotNull() {
            addCriterion("USERINFOIDS is not null");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsEqualTo(String value) {
            addCriterion("USERINFOIDS =", value, "userinfoids");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsNotEqualTo(String value) {
            addCriterion("USERINFOIDS <>", value, "userinfoids");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsGreaterThan(String value) {
            addCriterion("USERINFOIDS >", value, "userinfoids");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsGreaterThanOrEqualTo(String value) {
            addCriterion("USERINFOIDS >=", value, "userinfoids");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsLessThan(String value) {
            addCriterion("USERINFOIDS <", value, "userinfoids");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsLessThanOrEqualTo(String value) {
            addCriterion("USERINFOIDS <=", value, "userinfoids");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsLike(String value) {
            addCriterion("USERINFOIDS like", value, "userinfoids");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsNotLike(String value) {
            addCriterion("USERINFOIDS not like", value, "userinfoids");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsIn(List<String> values) {
            addCriterion("USERINFOIDS in", values, "userinfoids");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsNotIn(List<String> values) {
            addCriterion("USERINFOIDS not in", values, "userinfoids");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsBetween(String value1, String value2) {
            addCriterion("USERINFOIDS between", value1, value2, "userinfoids");
            return (Criteria) this;
        }

        public Criteria andUserinfoidsNotBetween(String value1, String value2) {
            addCriterion("USERINFOIDS not between", value1, value2, "userinfoids");
            return (Criteria) this;
        }

        public Criteria andStationidsIsNull() {
            addCriterion("STATIONIDS is null");
            return (Criteria) this;
        }

        public Criteria andStationidsIsNotNull() {
            addCriterion("STATIONIDS is not null");
            return (Criteria) this;
        }

        public Criteria andStationidsEqualTo(String value) {
            addCriterion("STATIONIDS =", value, "stationids");
            return (Criteria) this;
        }

        public Criteria andStationidsNotEqualTo(String value) {
            addCriterion("STATIONIDS <>", value, "stationids");
            return (Criteria) this;
        }

        public Criteria andStationidsGreaterThan(String value) {
            addCriterion("STATIONIDS >", value, "stationids");
            return (Criteria) this;
        }

        public Criteria andStationidsGreaterThanOrEqualTo(String value) {
            addCriterion("STATIONIDS >=", value, "stationids");
            return (Criteria) this;
        }

        public Criteria andStationidsLessThan(String value) {
            addCriterion("STATIONIDS <", value, "stationids");
            return (Criteria) this;
        }

        public Criteria andStationidsLessThanOrEqualTo(String value) {
            addCriterion("STATIONIDS <=", value, "stationids");
            return (Criteria) this;
        }

        public Criteria andStationidsLike(String value) {
            addCriterion("STATIONIDS like", value, "stationids");
            return (Criteria) this;
        }

        public Criteria andStationidsNotLike(String value) {
            addCriterion("STATIONIDS not like", value, "stationids");
            return (Criteria) this;
        }

        public Criteria andStationidsIn(List<String> values) {
            addCriterion("STATIONIDS in", values, "stationids");
            return (Criteria) this;
        }

        public Criteria andStationidsNotIn(List<String> values) {
            addCriterion("STATIONIDS not in", values, "stationids");
            return (Criteria) this;
        }

        public Criteria andStationidsBetween(String value1, String value2) {
            addCriterion("STATIONIDS between", value1, value2, "stationids");
            return (Criteria) this;
        }

        public Criteria andStationidsNotBetween(String value1, String value2) {
            addCriterion("STATIONIDS not between", value1, value2, "stationids");
            return (Criteria) this;
        }

        public Criteria andDeptidsIsNull() {
            addCriterion("DEPTIDS is null");
            return (Criteria) this;
        }

        public Criteria andDeptidsIsNotNull() {
            addCriterion("DEPTIDS is not null");
            return (Criteria) this;
        }

        public Criteria andDeptidsEqualTo(String value) {
            addCriterion("DEPTIDS =", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsNotEqualTo(String value) {
            addCriterion("DEPTIDS <>", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsGreaterThan(String value) {
            addCriterion("DEPTIDS >", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsGreaterThanOrEqualTo(String value) {
            addCriterion("DEPTIDS >=", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsLessThan(String value) {
            addCriterion("DEPTIDS <", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsLessThanOrEqualTo(String value) {
            addCriterion("DEPTIDS <=", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsLike(String value) {
            addCriterion("DEPTIDS like", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsNotLike(String value) {
            addCriterion("DEPTIDS not like", value, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsIn(List<String> values) {
            addCriterion("DEPTIDS in", values, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsNotIn(List<String> values) {
            addCriterion("DEPTIDS not in", values, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsBetween(String value1, String value2) {
            addCriterion("DEPTIDS between", value1, value2, "deptids");
            return (Criteria) this;
        }

        public Criteria andDeptidsNotBetween(String value1, String value2) {
            addCriterion("DEPTIDS not between", value1, value2, "deptids");
            return (Criteria) this;
        }

        public Criteria andUseridsIsNull() {
            addCriterion("USERIDS is null");
            return (Criteria) this;
        }

        public Criteria andUseridsIsNotNull() {
            addCriterion("USERIDS is not null");
            return (Criteria) this;
        }

        public Criteria andUseridsEqualTo(String value) {
            addCriterion("USERIDS =", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsNotEqualTo(String value) {
            addCriterion("USERIDS <>", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsGreaterThan(String value) {
            addCriterion("USERIDS >", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsGreaterThanOrEqualTo(String value) {
            addCriterion("USERIDS >=", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsLessThan(String value) {
            addCriterion("USERIDS <", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsLessThanOrEqualTo(String value) {
            addCriterion("USERIDS <=", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsLike(String value) {
            addCriterion("USERIDS like", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsNotLike(String value) {
            addCriterion("USERIDS not like", value, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsIn(List<String> values) {
            addCriterion("USERIDS in", values, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsNotIn(List<String> values) {
            addCriterion("USERIDS not in", values, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsBetween(String value1, String value2) {
            addCriterion("USERIDS between", value1, value2, "userids");
            return (Criteria) this;
        }

        public Criteria andUseridsNotBetween(String value1, String value2) {
            addCriterion("USERIDS not between", value1, value2, "userids");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesIsNull() {
            addCriterion("DEPARTMENTNAMES is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesIsNotNull() {
            addCriterion("DEPARTMENTNAMES is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesEqualTo(String value) {
            addCriterion("DEPARTMENTNAMES =", value, "departmentnames");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesNotEqualTo(String value) {
            addCriterion("DEPARTMENTNAMES <>", value, "departmentnames");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesGreaterThan(String value) {
            addCriterion("DEPARTMENTNAMES >", value, "departmentnames");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesGreaterThanOrEqualTo(String value) {
            addCriterion("DEPARTMENTNAMES >=", value, "departmentnames");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesLessThan(String value) {
            addCriterion("DEPARTMENTNAMES <", value, "departmentnames");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesLessThanOrEqualTo(String value) {
            addCriterion("DEPARTMENTNAMES <=", value, "departmentnames");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesLike(String value) {
            addCriterion("DEPARTMENTNAMES like", value, "departmentnames");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesNotLike(String value) {
            addCriterion("DEPARTMENTNAMES not like", value, "departmentnames");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesIn(List<String> values) {
            addCriterion("DEPARTMENTNAMES in", values, "departmentnames");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesNotIn(List<String> values) {
            addCriterion("DEPARTMENTNAMES not in", values, "departmentnames");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesBetween(String value1, String value2) {
            addCriterion("DEPARTMENTNAMES between", value1, value2, "departmentnames");
            return (Criteria) this;
        }

        public Criteria andDepartmentnamesNotBetween(String value1, String value2) {
            addCriterion("DEPARTMENTNAMES not between", value1, value2, "departmentnames");
            return (Criteria) this;
        }

        public Criteria andStationnamesIsNull() {
            addCriterion("STATIONNAMES is null");
            return (Criteria) this;
        }

        public Criteria andStationnamesIsNotNull() {
            addCriterion("STATIONNAMES is not null");
            return (Criteria) this;
        }

        public Criteria andStationnamesEqualTo(String value) {
            addCriterion("STATIONNAMES =", value, "stationnames");
            return (Criteria) this;
        }

        public Criteria andStationnamesNotEqualTo(String value) {
            addCriterion("STATIONNAMES <>", value, "stationnames");
            return (Criteria) this;
        }

        public Criteria andStationnamesGreaterThan(String value) {
            addCriterion("STATIONNAMES >", value, "stationnames");
            return (Criteria) this;
        }

        public Criteria andStationnamesGreaterThanOrEqualTo(String value) {
            addCriterion("STATIONNAMES >=", value, "stationnames");
            return (Criteria) this;
        }

        public Criteria andStationnamesLessThan(String value) {
            addCriterion("STATIONNAMES <", value, "stationnames");
            return (Criteria) this;
        }

        public Criteria andStationnamesLessThanOrEqualTo(String value) {
            addCriterion("STATIONNAMES <=", value, "stationnames");
            return (Criteria) this;
        }

        public Criteria andStationnamesLike(String value) {
            addCriterion("STATIONNAMES like", value, "stationnames");
            return (Criteria) this;
        }

        public Criteria andStationnamesNotLike(String value) {
            addCriterion("STATIONNAMES not like", value, "stationnames");
            return (Criteria) this;
        }

        public Criteria andStationnamesIn(List<String> values) {
            addCriterion("STATIONNAMES in", values, "stationnames");
            return (Criteria) this;
        }

        public Criteria andStationnamesNotIn(List<String> values) {
            addCriterion("STATIONNAMES not in", values, "stationnames");
            return (Criteria) this;
        }

        public Criteria andStationnamesBetween(String value1, String value2) {
            addCriterion("STATIONNAMES between", value1, value2, "stationnames");
            return (Criteria) this;
        }

        public Criteria andStationnamesNotBetween(String value1, String value2) {
            addCriterion("STATIONNAMES not between", value1, value2, "stationnames");
            return (Criteria) this;
        }

        public Criteria andDeptnamesIsNull() {
            addCriterion("DEPTNAMES is null");
            return (Criteria) this;
        }

        public Criteria andDeptnamesIsNotNull() {
            addCriterion("DEPTNAMES is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnamesEqualTo(String value) {
            addCriterion("DEPTNAMES =", value, "deptnames");
            return (Criteria) this;
        }

        public Criteria andDeptnamesNotEqualTo(String value) {
            addCriterion("DEPTNAMES <>", value, "deptnames");
            return (Criteria) this;
        }

        public Criteria andDeptnamesGreaterThan(String value) {
            addCriterion("DEPTNAMES >", value, "deptnames");
            return (Criteria) this;
        }

        public Criteria andDeptnamesGreaterThanOrEqualTo(String value) {
            addCriterion("DEPTNAMES >=", value, "deptnames");
            return (Criteria) this;
        }

        public Criteria andDeptnamesLessThan(String value) {
            addCriterion("DEPTNAMES <", value, "deptnames");
            return (Criteria) this;
        }

        public Criteria andDeptnamesLessThanOrEqualTo(String value) {
            addCriterion("DEPTNAMES <=", value, "deptnames");
            return (Criteria) this;
        }

        public Criteria andDeptnamesLike(String value) {
            addCriterion("DEPTNAMES like", value, "deptnames");
            return (Criteria) this;
        }

        public Criteria andDeptnamesNotLike(String value) {
            addCriterion("DEPTNAMES not like", value, "deptnames");
            return (Criteria) this;
        }

        public Criteria andDeptnamesIn(List<String> values) {
            addCriterion("DEPTNAMES in", values, "deptnames");
            return (Criteria) this;
        }

        public Criteria andDeptnamesNotIn(List<String> values) {
            addCriterion("DEPTNAMES not in", values, "deptnames");
            return (Criteria) this;
        }

        public Criteria andDeptnamesBetween(String value1, String value2) {
            addCriterion("DEPTNAMES between", value1, value2, "deptnames");
            return (Criteria) this;
        }

        public Criteria andDeptnamesNotBetween(String value1, String value2) {
            addCriterion("DEPTNAMES not between", value1, value2, "deptnames");
            return (Criteria) this;
        }

        public Criteria andUsernamesIsNull() {
            addCriterion("USERNAMES is null");
            return (Criteria) this;
        }

        public Criteria andUsernamesIsNotNull() {
            addCriterion("USERNAMES is not null");
            return (Criteria) this;
        }

        public Criteria andUsernamesEqualTo(String value) {
            addCriterion("USERNAMES =", value, "usernames");
            return (Criteria) this;
        }

        public Criteria andUsernamesNotEqualTo(String value) {
            addCriterion("USERNAMES <>", value, "usernames");
            return (Criteria) this;
        }

        public Criteria andUsernamesGreaterThan(String value) {
            addCriterion("USERNAMES >", value, "usernames");
            return (Criteria) this;
        }

        public Criteria andUsernamesGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAMES >=", value, "usernames");
            return (Criteria) this;
        }

        public Criteria andUsernamesLessThan(String value) {
            addCriterion("USERNAMES <", value, "usernames");
            return (Criteria) this;
        }

        public Criteria andUsernamesLessThanOrEqualTo(String value) {
            addCriterion("USERNAMES <=", value, "usernames");
            return (Criteria) this;
        }

        public Criteria andUsernamesLike(String value) {
            addCriterion("USERNAMES like", value, "usernames");
            return (Criteria) this;
        }

        public Criteria andUsernamesNotLike(String value) {
            addCriterion("USERNAMES not like", value, "usernames");
            return (Criteria) this;
        }

        public Criteria andUsernamesIn(List<String> values) {
            addCriterion("USERNAMES in", values, "usernames");
            return (Criteria) this;
        }

        public Criteria andUsernamesNotIn(List<String> values) {
            addCriterion("USERNAMES not in", values, "usernames");
            return (Criteria) this;
        }

        public Criteria andUsernamesBetween(String value1, String value2) {
            addCriterion("USERNAMES between", value1, value2, "usernames");
            return (Criteria) this;
        }

        public Criteria andUsernamesNotBetween(String value1, String value2) {
            addCriterion("USERNAMES not between", value1, value2, "usernames");
            return (Criteria) this;
        }

        public Criteria andGroupnamesIsNull() {
            addCriterion("GROUPNAMES is null");
            return (Criteria) this;
        }

        public Criteria andGroupnamesIsNotNull() {
            addCriterion("GROUPNAMES is not null");
            return (Criteria) this;
        }

        public Criteria andGroupnamesEqualTo(String value) {
            addCriterion("GROUPNAMES =", value, "groupnames");
            return (Criteria) this;
        }

        public Criteria andGroupnamesNotEqualTo(String value) {
            addCriterion("GROUPNAMES <>", value, "groupnames");
            return (Criteria) this;
        }

        public Criteria andGroupnamesGreaterThan(String value) {
            addCriterion("GROUPNAMES >", value, "groupnames");
            return (Criteria) this;
        }

        public Criteria andGroupnamesGreaterThanOrEqualTo(String value) {
            addCriterion("GROUPNAMES >=", value, "groupnames");
            return (Criteria) this;
        }

        public Criteria andGroupnamesLessThan(String value) {
            addCriterion("GROUPNAMES <", value, "groupnames");
            return (Criteria) this;
        }

        public Criteria andGroupnamesLessThanOrEqualTo(String value) {
            addCriterion("GROUPNAMES <=", value, "groupnames");
            return (Criteria) this;
        }

        public Criteria andGroupnamesLike(String value) {
            addCriterion("GROUPNAMES like", value, "groupnames");
            return (Criteria) this;
        }

        public Criteria andGroupnamesNotLike(String value) {
            addCriterion("GROUPNAMES not like", value, "groupnames");
            return (Criteria) this;
        }

        public Criteria andGroupnamesIn(List<String> values) {
            addCriterion("GROUPNAMES in", values, "groupnames");
            return (Criteria) this;
        }

        public Criteria andGroupnamesNotIn(List<String> values) {
            addCriterion("GROUPNAMES not in", values, "groupnames");
            return (Criteria) this;
        }

        public Criteria andGroupnamesBetween(String value1, String value2) {
            addCriterion("GROUPNAMES between", value1, value2, "groupnames");
            return (Criteria) this;
        }

        public Criteria andGroupnamesNotBetween(String value1, String value2) {
            addCriterion("GROUPNAMES not between", value1, value2, "groupnames");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserIsNull() {
            addCriterion("ISMERCHANTUSER is null");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserIsNotNull() {
            addCriterion("ISMERCHANTUSER is not null");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserEqualTo(String value) {
            addCriterion("ISMERCHANTUSER =", value, "ismerchantuser");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserNotEqualTo(String value) {
            addCriterion("ISMERCHANTUSER <>", value, "ismerchantuser");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserGreaterThan(String value) {
            addCriterion("ISMERCHANTUSER >", value, "ismerchantuser");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserGreaterThanOrEqualTo(String value) {
            addCriterion("ISMERCHANTUSER >=", value, "ismerchantuser");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserLessThan(String value) {
            addCriterion("ISMERCHANTUSER <", value, "ismerchantuser");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserLessThanOrEqualTo(String value) {
            addCriterion("ISMERCHANTUSER <=", value, "ismerchantuser");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserLike(String value) {
            addCriterion("ISMERCHANTUSER like", value, "ismerchantuser");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserNotLike(String value) {
            addCriterion("ISMERCHANTUSER not like", value, "ismerchantuser");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserIn(List<String> values) {
            addCriterion("ISMERCHANTUSER in", values, "ismerchantuser");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserNotIn(List<String> values) {
            addCriterion("ISMERCHANTUSER not in", values, "ismerchantuser");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserBetween(String value1, String value2) {
            addCriterion("ISMERCHANTUSER between", value1, value2, "ismerchantuser");
            return (Criteria) this;
        }

        public Criteria andIsmerchantuserNotBetween(String value1, String value2) {
            addCriterion("ISMERCHANTUSER not between", value1, value2, "ismerchantuser");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CREATETIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CREATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("CREATETIME =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("CREATETIME <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("CREATETIME >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATETIME >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("CREATETIME <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("CREATETIME <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("CREATETIME like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("CREATETIME not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("CREATETIME in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("CREATETIME not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("CREATETIME between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("CREATETIME not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andLogincountIsNull() {
            addCriterion("LOGINCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andLogincountIsNotNull() {
            addCriterion("LOGINCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andLogincountEqualTo(BigDecimal value) {
            addCriterion("LOGINCOUNT =", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountNotEqualTo(BigDecimal value) {
            addCriterion("LOGINCOUNT <>", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountGreaterThan(BigDecimal value) {
            addCriterion("LOGINCOUNT >", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOGINCOUNT >=", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountLessThan(BigDecimal value) {
            addCriterion("LOGINCOUNT <", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOGINCOUNT <=", value, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountIn(List<BigDecimal> values) {
            addCriterion("LOGINCOUNT in", values, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountNotIn(List<BigDecimal> values) {
            addCriterion("LOGINCOUNT not in", values, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOGINCOUNT between", value1, value2, "logincount");
            return (Criteria) this;
        }

        public Criteria andLogincountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOGINCOUNT not between", value1, value2, "logincount");
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