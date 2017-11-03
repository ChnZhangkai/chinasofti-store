package com.chinasofti.mall.common.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PyMainGoodsorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PyMainGoodsorderExample() {
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

        public Criteria andBigorderIdIsNull() {
            addCriterion("BIGORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andBigorderIdIsNotNull() {
            addCriterion("BIGORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBigorderIdEqualTo(String value) {
            addCriterion("BIGORDER_ID =", value, "bigorderId");
            return (Criteria) this;
        }

        public Criteria andBigorderIdNotEqualTo(String value) {
            addCriterion("BIGORDER_ID <>", value, "bigorderId");
            return (Criteria) this;
        }

        public Criteria andBigorderIdGreaterThan(String value) {
            addCriterion("BIGORDER_ID >", value, "bigorderId");
            return (Criteria) this;
        }

        public Criteria andBigorderIdGreaterThanOrEqualTo(String value) {
            addCriterion("BIGORDER_ID >=", value, "bigorderId");
            return (Criteria) this;
        }

        public Criteria andBigorderIdLessThan(String value) {
            addCriterion("BIGORDER_ID <", value, "bigorderId");
            return (Criteria) this;
        }

        public Criteria andBigorderIdLessThanOrEqualTo(String value) {
            addCriterion("BIGORDER_ID <=", value, "bigorderId");
            return (Criteria) this;
        }

        public Criteria andBigorderIdLike(String value) {
            addCriterion("BIGORDER_ID like", value, "bigorderId");
            return (Criteria) this;
        }

        public Criteria andBigorderIdNotLike(String value) {
            addCriterion("BIGORDER_ID not like", value, "bigorderId");
            return (Criteria) this;
        }

        public Criteria andBigorderIdIn(List<String> values) {
            addCriterion("BIGORDER_ID in", values, "bigorderId");
            return (Criteria) this;
        }

        public Criteria andBigorderIdNotIn(List<String> values) {
            addCriterion("BIGORDER_ID not in", values, "bigorderId");
            return (Criteria) this;
        }

        public Criteria andBigorderIdBetween(String value1, String value2) {
            addCriterion("BIGORDER_ID between", value1, value2, "bigorderId");
            return (Criteria) this;
        }

        public Criteria andBigorderIdNotBetween(String value1, String value2) {
            addCriterion("BIGORDER_ID not between", value1, value2, "bigorderId");
            return (Criteria) this;
        }

        public Criteria andVendorIdsIsNull() {
            addCriterion("VENDOR_IDS is null");
            return (Criteria) this;
        }

        public Criteria andVendorIdsIsNotNull() {
            addCriterion("VENDOR_IDS is not null");
            return (Criteria) this;
        }

        public Criteria andVendorIdsEqualTo(String value) {
            addCriterion("VENDOR_IDS =", value, "vendorIds");
            return (Criteria) this;
        }

        public Criteria andVendorIdsNotEqualTo(String value) {
            addCriterion("VENDOR_IDS <>", value, "vendorIds");
            return (Criteria) this;
        }

        public Criteria andVendorIdsGreaterThan(String value) {
            addCriterion("VENDOR_IDS >", value, "vendorIds");
            return (Criteria) this;
        }

        public Criteria andVendorIdsGreaterThanOrEqualTo(String value) {
            addCriterion("VENDOR_IDS >=", value, "vendorIds");
            return (Criteria) this;
        }

        public Criteria andVendorIdsLessThan(String value) {
            addCriterion("VENDOR_IDS <", value, "vendorIds");
            return (Criteria) this;
        }

        public Criteria andVendorIdsLessThanOrEqualTo(String value) {
            addCriterion("VENDOR_IDS <=", value, "vendorIds");
            return (Criteria) this;
        }

        public Criteria andVendorIdsLike(String value) {
            addCriterion("VENDOR_IDS like", value, "vendorIds");
            return (Criteria) this;
        }

        public Criteria andVendorIdsNotLike(String value) {
            addCriterion("VENDOR_IDS not like", value, "vendorIds");
            return (Criteria) this;
        }

        public Criteria andVendorIdsIn(List<String> values) {
            addCriterion("VENDOR_IDS in", values, "vendorIds");
            return (Criteria) this;
        }

        public Criteria andVendorIdsNotIn(List<String> values) {
            addCriterion("VENDOR_IDS not in", values, "vendorIds");
            return (Criteria) this;
        }

        public Criteria andVendorIdsBetween(String value1, String value2) {
            addCriterion("VENDOR_IDS between", value1, value2, "vendorIds");
            return (Criteria) this;
        }

        public Criteria andVendorIdsNotBetween(String value1, String value2) {
            addCriterion("VENDOR_IDS not between", value1, value2, "vendorIds");
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

        public Criteria andContPostcodeIsNull() {
            addCriterion("CONT_POSTCODE is null");
            return (Criteria) this;
        }

        public Criteria andContPostcodeIsNotNull() {
            addCriterion("CONT_POSTCODE is not null");
            return (Criteria) this;
        }

        public Criteria andContPostcodeEqualTo(String value) {
            addCriterion("CONT_POSTCODE =", value, "contPostcode");
            return (Criteria) this;
        }

        public Criteria andContPostcodeNotEqualTo(String value) {
            addCriterion("CONT_POSTCODE <>", value, "contPostcode");
            return (Criteria) this;
        }

        public Criteria andContPostcodeGreaterThan(String value) {
            addCriterion("CONT_POSTCODE >", value, "contPostcode");
            return (Criteria) this;
        }

        public Criteria andContPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_POSTCODE >=", value, "contPostcode");
            return (Criteria) this;
        }

        public Criteria andContPostcodeLessThan(String value) {
            addCriterion("CONT_POSTCODE <", value, "contPostcode");
            return (Criteria) this;
        }

        public Criteria andContPostcodeLessThanOrEqualTo(String value) {
            addCriterion("CONT_POSTCODE <=", value, "contPostcode");
            return (Criteria) this;
        }

        public Criteria andContPostcodeLike(String value) {
            addCriterion("CONT_POSTCODE like", value, "contPostcode");
            return (Criteria) this;
        }

        public Criteria andContPostcodeNotLike(String value) {
            addCriterion("CONT_POSTCODE not like", value, "contPostcode");
            return (Criteria) this;
        }

        public Criteria andContPostcodeIn(List<String> values) {
            addCriterion("CONT_POSTCODE in", values, "contPostcode");
            return (Criteria) this;
        }

        public Criteria andContPostcodeNotIn(List<String> values) {
            addCriterion("CONT_POSTCODE not in", values, "contPostcode");
            return (Criteria) this;
        }

        public Criteria andContPostcodeBetween(String value1, String value2) {
            addCriterion("CONT_POSTCODE between", value1, value2, "contPostcode");
            return (Criteria) this;
        }

        public Criteria andContPostcodeNotBetween(String value1, String value2) {
            addCriterion("CONT_POSTCODE not between", value1, value2, "contPostcode");
            return (Criteria) this;
        }

        public Criteria andContAddressIsNull() {
            addCriterion("CONT_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andContAddressIsNotNull() {
            addCriterion("CONT_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andContAddressEqualTo(String value) {
            addCriterion("CONT_ADDRESS =", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressNotEqualTo(String value) {
            addCriterion("CONT_ADDRESS <>", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressGreaterThan(String value) {
            addCriterion("CONT_ADDRESS >", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_ADDRESS >=", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressLessThan(String value) {
            addCriterion("CONT_ADDRESS <", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressLessThanOrEqualTo(String value) {
            addCriterion("CONT_ADDRESS <=", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressLike(String value) {
            addCriterion("CONT_ADDRESS like", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressNotLike(String value) {
            addCriterion("CONT_ADDRESS not like", value, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressIn(List<String> values) {
            addCriterion("CONT_ADDRESS in", values, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressNotIn(List<String> values) {
            addCriterion("CONT_ADDRESS not in", values, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressBetween(String value1, String value2) {
            addCriterion("CONT_ADDRESS between", value1, value2, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContAddressNotBetween(String value1, String value2) {
            addCriterion("CONT_ADDRESS not between", value1, value2, "contAddress");
            return (Criteria) this;
        }

        public Criteria andContMobileIsNull() {
            addCriterion("CONT_MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andContMobileIsNotNull() {
            addCriterion("CONT_MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andContMobileEqualTo(String value) {
            addCriterion("CONT_MOBILE =", value, "contMobile");
            return (Criteria) this;
        }

        public Criteria andContMobileNotEqualTo(String value) {
            addCriterion("CONT_MOBILE <>", value, "contMobile");
            return (Criteria) this;
        }

        public Criteria andContMobileGreaterThan(String value) {
            addCriterion("CONT_MOBILE >", value, "contMobile");
            return (Criteria) this;
        }

        public Criteria andContMobileGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_MOBILE >=", value, "contMobile");
            return (Criteria) this;
        }

        public Criteria andContMobileLessThan(String value) {
            addCriterion("CONT_MOBILE <", value, "contMobile");
            return (Criteria) this;
        }

        public Criteria andContMobileLessThanOrEqualTo(String value) {
            addCriterion("CONT_MOBILE <=", value, "contMobile");
            return (Criteria) this;
        }

        public Criteria andContMobileLike(String value) {
            addCriterion("CONT_MOBILE like", value, "contMobile");
            return (Criteria) this;
        }

        public Criteria andContMobileNotLike(String value) {
            addCriterion("CONT_MOBILE not like", value, "contMobile");
            return (Criteria) this;
        }

        public Criteria andContMobileIn(List<String> values) {
            addCriterion("CONT_MOBILE in", values, "contMobile");
            return (Criteria) this;
        }

        public Criteria andContMobileNotIn(List<String> values) {
            addCriterion("CONT_MOBILE not in", values, "contMobile");
            return (Criteria) this;
        }

        public Criteria andContMobileBetween(String value1, String value2) {
            addCriterion("CONT_MOBILE between", value1, value2, "contMobile");
            return (Criteria) this;
        }

        public Criteria andContMobileNotBetween(String value1, String value2) {
            addCriterion("CONT_MOBILE not between", value1, value2, "contMobile");
            return (Criteria) this;
        }

        public Criteria andContPhoneIsNull() {
            addCriterion("CONT_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andContPhoneIsNotNull() {
            addCriterion("CONT_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andContPhoneEqualTo(String value) {
            addCriterion("CONT_PHONE =", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneNotEqualTo(String value) {
            addCriterion("CONT_PHONE <>", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneGreaterThan(String value) {
            addCriterion("CONT_PHONE >", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_PHONE >=", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneLessThan(String value) {
            addCriterion("CONT_PHONE <", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneLessThanOrEqualTo(String value) {
            addCriterion("CONT_PHONE <=", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneLike(String value) {
            addCriterion("CONT_PHONE like", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneNotLike(String value) {
            addCriterion("CONT_PHONE not like", value, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneIn(List<String> values) {
            addCriterion("CONT_PHONE in", values, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneNotIn(List<String> values) {
            addCriterion("CONT_PHONE not in", values, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneBetween(String value1, String value2) {
            addCriterion("CONT_PHONE between", value1, value2, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContPhoneNotBetween(String value1, String value2) {
            addCriterion("CONT_PHONE not between", value1, value2, "contPhone");
            return (Criteria) this;
        }

        public Criteria andContProvinceIsNull() {
            addCriterion("CONT_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andContProvinceIsNotNull() {
            addCriterion("CONT_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andContProvinceEqualTo(String value) {
            addCriterion("CONT_PROVINCE =", value, "contProvince");
            return (Criteria) this;
        }

        public Criteria andContProvinceNotEqualTo(String value) {
            addCriterion("CONT_PROVINCE <>", value, "contProvince");
            return (Criteria) this;
        }

        public Criteria andContProvinceGreaterThan(String value) {
            addCriterion("CONT_PROVINCE >", value, "contProvince");
            return (Criteria) this;
        }

        public Criteria andContProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_PROVINCE >=", value, "contProvince");
            return (Criteria) this;
        }

        public Criteria andContProvinceLessThan(String value) {
            addCriterion("CONT_PROVINCE <", value, "contProvince");
            return (Criteria) this;
        }

        public Criteria andContProvinceLessThanOrEqualTo(String value) {
            addCriterion("CONT_PROVINCE <=", value, "contProvince");
            return (Criteria) this;
        }

        public Criteria andContProvinceLike(String value) {
            addCriterion("CONT_PROVINCE like", value, "contProvince");
            return (Criteria) this;
        }

        public Criteria andContProvinceNotLike(String value) {
            addCriterion("CONT_PROVINCE not like", value, "contProvince");
            return (Criteria) this;
        }

        public Criteria andContProvinceIn(List<String> values) {
            addCriterion("CONT_PROVINCE in", values, "contProvince");
            return (Criteria) this;
        }

        public Criteria andContProvinceNotIn(List<String> values) {
            addCriterion("CONT_PROVINCE not in", values, "contProvince");
            return (Criteria) this;
        }

        public Criteria andContProvinceBetween(String value1, String value2) {
            addCriterion("CONT_PROVINCE between", value1, value2, "contProvince");
            return (Criteria) this;
        }

        public Criteria andContProvinceNotBetween(String value1, String value2) {
            addCriterion("CONT_PROVINCE not between", value1, value2, "contProvince");
            return (Criteria) this;
        }

        public Criteria andContCityIsNull() {
            addCriterion("CONT_CITY is null");
            return (Criteria) this;
        }

        public Criteria andContCityIsNotNull() {
            addCriterion("CONT_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andContCityEqualTo(String value) {
            addCriterion("CONT_CITY =", value, "contCity");
            return (Criteria) this;
        }

        public Criteria andContCityNotEqualTo(String value) {
            addCriterion("CONT_CITY <>", value, "contCity");
            return (Criteria) this;
        }

        public Criteria andContCityGreaterThan(String value) {
            addCriterion("CONT_CITY >", value, "contCity");
            return (Criteria) this;
        }

        public Criteria andContCityGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_CITY >=", value, "contCity");
            return (Criteria) this;
        }

        public Criteria andContCityLessThan(String value) {
            addCriterion("CONT_CITY <", value, "contCity");
            return (Criteria) this;
        }

        public Criteria andContCityLessThanOrEqualTo(String value) {
            addCriterion("CONT_CITY <=", value, "contCity");
            return (Criteria) this;
        }

        public Criteria andContCityLike(String value) {
            addCriterion("CONT_CITY like", value, "contCity");
            return (Criteria) this;
        }

        public Criteria andContCityNotLike(String value) {
            addCriterion("CONT_CITY not like", value, "contCity");
            return (Criteria) this;
        }

        public Criteria andContCityIn(List<String> values) {
            addCriterion("CONT_CITY in", values, "contCity");
            return (Criteria) this;
        }

        public Criteria andContCityNotIn(List<String> values) {
            addCriterion("CONT_CITY not in", values, "contCity");
            return (Criteria) this;
        }

        public Criteria andContCityBetween(String value1, String value2) {
            addCriterion("CONT_CITY between", value1, value2, "contCity");
            return (Criteria) this;
        }

        public Criteria andContCityNotBetween(String value1, String value2) {
            addCriterion("CONT_CITY not between", value1, value2, "contCity");
            return (Criteria) this;
        }

        public Criteria andContDistrictIsNull() {
            addCriterion("CONT_DISTRICT is null");
            return (Criteria) this;
        }

        public Criteria andContDistrictIsNotNull() {
            addCriterion("CONT_DISTRICT is not null");
            return (Criteria) this;
        }

        public Criteria andContDistrictEqualTo(String value) {
            addCriterion("CONT_DISTRICT =", value, "contDistrict");
            return (Criteria) this;
        }

        public Criteria andContDistrictNotEqualTo(String value) {
            addCriterion("CONT_DISTRICT <>", value, "contDistrict");
            return (Criteria) this;
        }

        public Criteria andContDistrictGreaterThan(String value) {
            addCriterion("CONT_DISTRICT >", value, "contDistrict");
            return (Criteria) this;
        }

        public Criteria andContDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_DISTRICT >=", value, "contDistrict");
            return (Criteria) this;
        }

        public Criteria andContDistrictLessThan(String value) {
            addCriterion("CONT_DISTRICT <", value, "contDistrict");
            return (Criteria) this;
        }

        public Criteria andContDistrictLessThanOrEqualTo(String value) {
            addCriterion("CONT_DISTRICT <=", value, "contDistrict");
            return (Criteria) this;
        }

        public Criteria andContDistrictLike(String value) {
            addCriterion("CONT_DISTRICT like", value, "contDistrict");
            return (Criteria) this;
        }

        public Criteria andContDistrictNotLike(String value) {
            addCriterion("CONT_DISTRICT not like", value, "contDistrict");
            return (Criteria) this;
        }

        public Criteria andContDistrictIn(List<String> values) {
            addCriterion("CONT_DISTRICT in", values, "contDistrict");
            return (Criteria) this;
        }

        public Criteria andContDistrictNotIn(List<String> values) {
            addCriterion("CONT_DISTRICT not in", values, "contDistrict");
            return (Criteria) this;
        }

        public Criteria andContDistrictBetween(String value1, String value2) {
            addCriterion("CONT_DISTRICT between", value1, value2, "contDistrict");
            return (Criteria) this;
        }

        public Criteria andContDistrictNotBetween(String value1, String value2) {
            addCriterion("CONT_DISTRICT not between", value1, value2, "contDistrict");
            return (Criteria) this;
        }

        public Criteria andContStreetIsNull() {
            addCriterion("CONT_STREET is null");
            return (Criteria) this;
        }

        public Criteria andContStreetIsNotNull() {
            addCriterion("CONT_STREET is not null");
            return (Criteria) this;
        }

        public Criteria andContStreetEqualTo(String value) {
            addCriterion("CONT_STREET =", value, "contStreet");
            return (Criteria) this;
        }

        public Criteria andContStreetNotEqualTo(String value) {
            addCriterion("CONT_STREET <>", value, "contStreet");
            return (Criteria) this;
        }

        public Criteria andContStreetGreaterThan(String value) {
            addCriterion("CONT_STREET >", value, "contStreet");
            return (Criteria) this;
        }

        public Criteria andContStreetGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_STREET >=", value, "contStreet");
            return (Criteria) this;
        }

        public Criteria andContStreetLessThan(String value) {
            addCriterion("CONT_STREET <", value, "contStreet");
            return (Criteria) this;
        }

        public Criteria andContStreetLessThanOrEqualTo(String value) {
            addCriterion("CONT_STREET <=", value, "contStreet");
            return (Criteria) this;
        }

        public Criteria andContStreetLike(String value) {
            addCriterion("CONT_STREET like", value, "contStreet");
            return (Criteria) this;
        }

        public Criteria andContStreetNotLike(String value) {
            addCriterion("CONT_STREET not like", value, "contStreet");
            return (Criteria) this;
        }

        public Criteria andContStreetIn(List<String> values) {
            addCriterion("CONT_STREET in", values, "contStreet");
            return (Criteria) this;
        }

        public Criteria andContStreetNotIn(List<String> values) {
            addCriterion("CONT_STREET not in", values, "contStreet");
            return (Criteria) this;
        }

        public Criteria andContStreetBetween(String value1, String value2) {
            addCriterion("CONT_STREET between", value1, value2, "contStreet");
            return (Criteria) this;
        }

        public Criteria andContStreetNotBetween(String value1, String value2) {
            addCriterion("CONT_STREET not between", value1, value2, "contStreet");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNull() {
            addCriterion("DELIVERY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIsNotNull() {
            addCriterion("DELIVERY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeEqualTo(String value) {
            addCriterion("DELIVERY_TIME =", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotEqualTo(String value) {
            addCriterion("DELIVERY_TIME <>", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThan(String value) {
            addCriterion("DELIVERY_TIME >", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_TIME >=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThan(String value) {
            addCriterion("DELIVERY_TIME <", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_TIME <=", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeLike(String value) {
            addCriterion("DELIVERY_TIME like", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotLike(String value) {
            addCriterion("DELIVERY_TIME not like", value, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeIn(List<String> values) {
            addCriterion("DELIVERY_TIME in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotIn(List<String> values) {
            addCriterion("DELIVERY_TIME not in", values, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeBetween(String value1, String value2) {
            addCriterion("DELIVERY_TIME between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryTimeNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_TIME not between", value1, value2, "deliveryTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNull() {
            addCriterion("DELIVERY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNotNull() {
            addCriterion("DELIVERY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateEqualTo(String value) {
            addCriterion("DELIVERY_DATE =", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotEqualTo(String value) {
            addCriterion("DELIVERY_DATE <>", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThan(String value) {
            addCriterion("DELIVERY_DATE >", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_DATE >=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThan(String value) {
            addCriterion("DELIVERY_DATE <", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_DATE <=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLike(String value) {
            addCriterion("DELIVERY_DATE like", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotLike(String value) {
            addCriterion("DELIVERY_DATE not like", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIn(List<String> values) {
            addCriterion("DELIVERY_DATE in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotIn(List<String> values) {
            addCriterion("DELIVERY_DATE not in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateBetween(String value1, String value2) {
            addCriterion("DELIVERY_DATE between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_DATE not between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayIsNull() {
            addCriterion("DELIVERY_WAY is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayIsNotNull() {
            addCriterion("DELIVERY_WAY is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayEqualTo(String value) {
            addCriterion("DELIVERY_WAY =", value, "deliveryWay");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayNotEqualTo(String value) {
            addCriterion("DELIVERY_WAY <>", value, "deliveryWay");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayGreaterThan(String value) {
            addCriterion("DELIVERY_WAY >", value, "deliveryWay");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayGreaterThanOrEqualTo(String value) {
            addCriterion("DELIVERY_WAY >=", value, "deliveryWay");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayLessThan(String value) {
            addCriterion("DELIVERY_WAY <", value, "deliveryWay");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayLessThanOrEqualTo(String value) {
            addCriterion("DELIVERY_WAY <=", value, "deliveryWay");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayLike(String value) {
            addCriterion("DELIVERY_WAY like", value, "deliveryWay");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayNotLike(String value) {
            addCriterion("DELIVERY_WAY not like", value, "deliveryWay");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayIn(List<String> values) {
            addCriterion("DELIVERY_WAY in", values, "deliveryWay");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayNotIn(List<String> values) {
            addCriterion("DELIVERY_WAY not in", values, "deliveryWay");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayBetween(String value1, String value2) {
            addCriterion("DELIVERY_WAY between", value1, value2, "deliveryWay");
            return (Criteria) this;
        }

        public Criteria andDeliveryWayNotBetween(String value1, String value2) {
            addCriterion("DELIVERY_WAY not between", value1, value2, "deliveryWay");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageIsNull() {
            addCriterion("BUYERS_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageIsNotNull() {
            addCriterion("BUYERS_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageEqualTo(String value) {
            addCriterion("BUYERS_MESSAGE =", value, "buyersMessage");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageNotEqualTo(String value) {
            addCriterion("BUYERS_MESSAGE <>", value, "buyersMessage");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageGreaterThan(String value) {
            addCriterion("BUYERS_MESSAGE >", value, "buyersMessage");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageGreaterThanOrEqualTo(String value) {
            addCriterion("BUYERS_MESSAGE >=", value, "buyersMessage");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageLessThan(String value) {
            addCriterion("BUYERS_MESSAGE <", value, "buyersMessage");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageLessThanOrEqualTo(String value) {
            addCriterion("BUYERS_MESSAGE <=", value, "buyersMessage");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageLike(String value) {
            addCriterion("BUYERS_MESSAGE like", value, "buyersMessage");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageNotLike(String value) {
            addCriterion("BUYERS_MESSAGE not like", value, "buyersMessage");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageIn(List<String> values) {
            addCriterion("BUYERS_MESSAGE in", values, "buyersMessage");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageNotIn(List<String> values) {
            addCriterion("BUYERS_MESSAGE not in", values, "buyersMessage");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageBetween(String value1, String value2) {
            addCriterion("BUYERS_MESSAGE between", value1, value2, "buyersMessage");
            return (Criteria) this;
        }

        public Criteria andBuyersMessageNotBetween(String value1, String value2) {
            addCriterion("BUYERS_MESSAGE not between", value1, value2, "buyersMessage");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("ORDER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("ORDER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(String value) {
            addCriterion("ORDER_TIME =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(String value) {
            addCriterion("ORDER_TIME <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(String value) {
            addCriterion("ORDER_TIME >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_TIME >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(String value) {
            addCriterion("ORDER_TIME <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(String value) {
            addCriterion("ORDER_TIME <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLike(String value) {
            addCriterion("ORDER_TIME like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotLike(String value) {
            addCriterion("ORDER_TIME not like", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<String> values) {
            addCriterion("ORDER_TIME in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<String> values) {
            addCriterion("ORDER_TIME not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(String value1, String value2) {
            addCriterion("ORDER_TIME between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(String value1, String value2) {
            addCriterion("ORDER_TIME not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeIsNull() {
            addCriterion("SETTLE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSettleTimeIsNotNull() {
            addCriterion("SETTLE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSettleTimeEqualTo(String value) {
            addCriterion("SETTLE_TIME =", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeNotEqualTo(String value) {
            addCriterion("SETTLE_TIME <>", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeGreaterThan(String value) {
            addCriterion("SETTLE_TIME >", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_TIME >=", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeLessThan(String value) {
            addCriterion("SETTLE_TIME <", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_TIME <=", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeLike(String value) {
            addCriterion("SETTLE_TIME like", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeNotLike(String value) {
            addCriterion("SETTLE_TIME not like", value, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeIn(List<String> values) {
            addCriterion("SETTLE_TIME in", values, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeNotIn(List<String> values) {
            addCriterion("SETTLE_TIME not in", values, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeBetween(String value1, String value2) {
            addCriterion("SETTLE_TIME between", value1, value2, "settleTime");
            return (Criteria) this;
        }

        public Criteria andSettleTimeNotBetween(String value1, String value2) {
            addCriterion("SETTLE_TIME not between", value1, value2, "settleTime");
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

        public Criteria andSettleAmtIsNull() {
            addCriterion("SETTLE_AMT is null");
            return (Criteria) this;
        }

        public Criteria andSettleAmtIsNotNull() {
            addCriterion("SETTLE_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andSettleAmtEqualTo(BigDecimal value) {
            addCriterion("SETTLE_AMT =", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtNotEqualTo(BigDecimal value) {
            addCriterion("SETTLE_AMT <>", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtGreaterThan(BigDecimal value) {
            addCriterion("SETTLE_AMT >", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLE_AMT >=", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtLessThan(BigDecimal value) {
            addCriterion("SETTLE_AMT <", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SETTLE_AMT <=", value, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtIn(List<BigDecimal> values) {
            addCriterion("SETTLE_AMT in", values, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtNotIn(List<BigDecimal> values) {
            addCriterion("SETTLE_AMT not in", values, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLE_AMT between", value1, value2, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SETTLE_AMT not between", value1, value2, "settleAmt");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesIsNull() {
            addCriterion("SETTLE_STATUES is null");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesIsNotNull() {
            addCriterion("SETTLE_STATUES is not null");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesEqualTo(String value) {
            addCriterion("SETTLE_STATUES =", value, "settleStatues");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesNotEqualTo(String value) {
            addCriterion("SETTLE_STATUES <>", value, "settleStatues");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesGreaterThan(String value) {
            addCriterion("SETTLE_STATUES >", value, "settleStatues");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_STATUES >=", value, "settleStatues");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesLessThan(String value) {
            addCriterion("SETTLE_STATUES <", value, "settleStatues");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_STATUES <=", value, "settleStatues");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesLike(String value) {
            addCriterion("SETTLE_STATUES like", value, "settleStatues");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesNotLike(String value) {
            addCriterion("SETTLE_STATUES not like", value, "settleStatues");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesIn(List<String> values) {
            addCriterion("SETTLE_STATUES in", values, "settleStatues");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesNotIn(List<String> values) {
            addCriterion("SETTLE_STATUES not in", values, "settleStatues");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesBetween(String value1, String value2) {
            addCriterion("SETTLE_STATUES between", value1, value2, "settleStatues");
            return (Criteria) this;
        }

        public Criteria andSettleStatuesNotBetween(String value1, String value2) {
            addCriterion("SETTLE_STATUES not between", value1, value2, "settleStatues");
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

        public Criteria andContNameIsNull() {
            addCriterion("CONT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andContNameIsNotNull() {
            addCriterion("CONT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andContNameEqualTo(String value) {
            addCriterion("CONT_NAME =", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameNotEqualTo(String value) {
            addCriterion("CONT_NAME <>", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameGreaterThan(String value) {
            addCriterion("CONT_NAME >", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_NAME >=", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameLessThan(String value) {
            addCriterion("CONT_NAME <", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameLessThanOrEqualTo(String value) {
            addCriterion("CONT_NAME <=", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameLike(String value) {
            addCriterion("CONT_NAME like", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameNotLike(String value) {
            addCriterion("CONT_NAME not like", value, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameIn(List<String> values) {
            addCriterion("CONT_NAME in", values, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameNotIn(List<String> values) {
            addCriterion("CONT_NAME not in", values, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameBetween(String value1, String value2) {
            addCriterion("CONT_NAME between", value1, value2, "contName");
            return (Criteria) this;
        }

        public Criteria andContNameNotBetween(String value1, String value2) {
            addCriterion("CONT_NAME not between", value1, value2, "contName");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoIsNull() {
            addCriterion("SETTLE_BATCH_NO is null");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoIsNotNull() {
            addCriterion("SETTLE_BATCH_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoEqualTo(String value) {
            addCriterion("SETTLE_BATCH_NO =", value, "settleBatchNo");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoNotEqualTo(String value) {
            addCriterion("SETTLE_BATCH_NO <>", value, "settleBatchNo");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoGreaterThan(String value) {
            addCriterion("SETTLE_BATCH_NO >", value, "settleBatchNo");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_BATCH_NO >=", value, "settleBatchNo");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoLessThan(String value) {
            addCriterion("SETTLE_BATCH_NO <", value, "settleBatchNo");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_BATCH_NO <=", value, "settleBatchNo");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoLike(String value) {
            addCriterion("SETTLE_BATCH_NO like", value, "settleBatchNo");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoNotLike(String value) {
            addCriterion("SETTLE_BATCH_NO not like", value, "settleBatchNo");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoIn(List<String> values) {
            addCriterion("SETTLE_BATCH_NO in", values, "settleBatchNo");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoNotIn(List<String> values) {
            addCriterion("SETTLE_BATCH_NO not in", values, "settleBatchNo");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoBetween(String value1, String value2) {
            addCriterion("SETTLE_BATCH_NO between", value1, value2, "settleBatchNo");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoNotBetween(String value1, String value2) {
            addCriterion("SETTLE_BATCH_NO not between", value1, value2, "settleBatchNo");
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

        public Criteria andSettleStatusFeeIsNull() {
            addCriterion("SETTLE_STATUS_FEE is null");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeIsNotNull() {
            addCriterion("SETTLE_STATUS_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeEqualTo(String value) {
            addCriterion("SETTLE_STATUS_FEE =", value, "settleStatusFee");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeNotEqualTo(String value) {
            addCriterion("SETTLE_STATUS_FEE <>", value, "settleStatusFee");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeGreaterThan(String value) {
            addCriterion("SETTLE_STATUS_FEE >", value, "settleStatusFee");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_STATUS_FEE >=", value, "settleStatusFee");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeLessThan(String value) {
            addCriterion("SETTLE_STATUS_FEE <", value, "settleStatusFee");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_STATUS_FEE <=", value, "settleStatusFee");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeLike(String value) {
            addCriterion("SETTLE_STATUS_FEE like", value, "settleStatusFee");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeNotLike(String value) {
            addCriterion("SETTLE_STATUS_FEE not like", value, "settleStatusFee");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeIn(List<String> values) {
            addCriterion("SETTLE_STATUS_FEE in", values, "settleStatusFee");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeNotIn(List<String> values) {
            addCriterion("SETTLE_STATUS_FEE not in", values, "settleStatusFee");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeBetween(String value1, String value2) {
            addCriterion("SETTLE_STATUS_FEE between", value1, value2, "settleStatusFee");
            return (Criteria) this;
        }

        public Criteria andSettleStatusFeeNotBetween(String value1, String value2) {
            addCriterion("SETTLE_STATUS_FEE not between", value1, value2, "settleStatusFee");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeIsNull() {
            addCriterion("SETTLE_TIME_FEE is null");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeIsNotNull() {
            addCriterion("SETTLE_TIME_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeEqualTo(String value) {
            addCriterion("SETTLE_TIME_FEE =", value, "settleTimeFee");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeNotEqualTo(String value) {
            addCriterion("SETTLE_TIME_FEE <>", value, "settleTimeFee");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeGreaterThan(String value) {
            addCriterion("SETTLE_TIME_FEE >", value, "settleTimeFee");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_TIME_FEE >=", value, "settleTimeFee");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeLessThan(String value) {
            addCriterion("SETTLE_TIME_FEE <", value, "settleTimeFee");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_TIME_FEE <=", value, "settleTimeFee");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeLike(String value) {
            addCriterion("SETTLE_TIME_FEE like", value, "settleTimeFee");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeNotLike(String value) {
            addCriterion("SETTLE_TIME_FEE not like", value, "settleTimeFee");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeIn(List<String> values) {
            addCriterion("SETTLE_TIME_FEE in", values, "settleTimeFee");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeNotIn(List<String> values) {
            addCriterion("SETTLE_TIME_FEE not in", values, "settleTimeFee");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeBetween(String value1, String value2) {
            addCriterion("SETTLE_TIME_FEE between", value1, value2, "settleTimeFee");
            return (Criteria) this;
        }

        public Criteria andSettleTimeFeeNotBetween(String value1, String value2) {
            addCriterion("SETTLE_TIME_FEE not between", value1, value2, "settleTimeFee");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeIsNull() {
            addCriterion("SETTLE_BATCH_NO_FEE is null");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeIsNotNull() {
            addCriterion("SETTLE_BATCH_NO_FEE is not null");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeEqualTo(String value) {
            addCriterion("SETTLE_BATCH_NO_FEE =", value, "settleBatchNoFee");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeNotEqualTo(String value) {
            addCriterion("SETTLE_BATCH_NO_FEE <>", value, "settleBatchNoFee");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeGreaterThan(String value) {
            addCriterion("SETTLE_BATCH_NO_FEE >", value, "settleBatchNoFee");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeGreaterThanOrEqualTo(String value) {
            addCriterion("SETTLE_BATCH_NO_FEE >=", value, "settleBatchNoFee");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeLessThan(String value) {
            addCriterion("SETTLE_BATCH_NO_FEE <", value, "settleBatchNoFee");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeLessThanOrEqualTo(String value) {
            addCriterion("SETTLE_BATCH_NO_FEE <=", value, "settleBatchNoFee");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeLike(String value) {
            addCriterion("SETTLE_BATCH_NO_FEE like", value, "settleBatchNoFee");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeNotLike(String value) {
            addCriterion("SETTLE_BATCH_NO_FEE not like", value, "settleBatchNoFee");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeIn(List<String> values) {
            addCriterion("SETTLE_BATCH_NO_FEE in", values, "settleBatchNoFee");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeNotIn(List<String> values) {
            addCriterion("SETTLE_BATCH_NO_FEE not in", values, "settleBatchNoFee");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeBetween(String value1, String value2) {
            addCriterion("SETTLE_BATCH_NO_FEE between", value1, value2, "settleBatchNoFee");
            return (Criteria) this;
        }

        public Criteria andSettleBatchNoFeeNotBetween(String value1, String value2) {
            addCriterion("SETTLE_BATCH_NO_FEE not between", value1, value2, "settleBatchNoFee");
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

        public Criteria andExpressCompanyIdIsNull() {
            addCriterion("EXPRESS_COMPANY_ID is null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdIsNotNull() {
            addCriterion("EXPRESS_COMPANY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdEqualTo(String value) {
            addCriterion("EXPRESS_COMPANY_ID =", value, "expressCompanyId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdNotEqualTo(String value) {
            addCriterion("EXPRESS_COMPANY_ID <>", value, "expressCompanyId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdGreaterThan(String value) {
            addCriterion("EXPRESS_COMPANY_ID >", value, "expressCompanyId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXPRESS_COMPANY_ID >=", value, "expressCompanyId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdLessThan(String value) {
            addCriterion("EXPRESS_COMPANY_ID <", value, "expressCompanyId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("EXPRESS_COMPANY_ID <=", value, "expressCompanyId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdLike(String value) {
            addCriterion("EXPRESS_COMPANY_ID like", value, "expressCompanyId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdNotLike(String value) {
            addCriterion("EXPRESS_COMPANY_ID not like", value, "expressCompanyId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdIn(List<String> values) {
            addCriterion("EXPRESS_COMPANY_ID in", values, "expressCompanyId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdNotIn(List<String> values) {
            addCriterion("EXPRESS_COMPANY_ID not in", values, "expressCompanyId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdBetween(String value1, String value2) {
            addCriterion("EXPRESS_COMPANY_ID between", value1, value2, "expressCompanyId");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIdNotBetween(String value1, String value2) {
            addCriterion("EXPRESS_COMPANY_ID not between", value1, value2, "expressCompanyId");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNull() {
            addCriterion("EXPRESS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNotNull() {
            addCriterion("EXPRESS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNameEqualTo(String value) {
            addCriterion("EXPRESS_NAME =", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotEqualTo(String value) {
            addCriterion("EXPRESS_NAME <>", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThan(String value) {
            addCriterion("EXPRESS_NAME >", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            addCriterion("EXPRESS_NAME >=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThan(String value) {
            addCriterion("EXPRESS_NAME <", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThanOrEqualTo(String value) {
            addCriterion("EXPRESS_NAME <=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLike(String value) {
            addCriterion("EXPRESS_NAME like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotLike(String value) {
            addCriterion("EXPRESS_NAME not like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameIn(List<String> values) {
            addCriterion("EXPRESS_NAME in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotIn(List<String> values) {
            addCriterion("EXPRESS_NAME not in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameBetween(String value1, String value2) {
            addCriterion("EXPRESS_NAME between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotBetween(String value1, String value2) {
            addCriterion("EXPRESS_NAME not between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressIdIsNull() {
            addCriterion("EXPRESS_ID is null");
            return (Criteria) this;
        }

        public Criteria andExpressIdIsNotNull() {
            addCriterion("EXPRESS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExpressIdEqualTo(String value) {
            addCriterion("EXPRESS_ID =", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotEqualTo(String value) {
            addCriterion("EXPRESS_ID <>", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdGreaterThan(String value) {
            addCriterion("EXPRESS_ID >", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdGreaterThanOrEqualTo(String value) {
            addCriterion("EXPRESS_ID >=", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdLessThan(String value) {
            addCriterion("EXPRESS_ID <", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdLessThanOrEqualTo(String value) {
            addCriterion("EXPRESS_ID <=", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdLike(String value) {
            addCriterion("EXPRESS_ID like", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotLike(String value) {
            addCriterion("EXPRESS_ID not like", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdIn(List<String> values) {
            addCriterion("EXPRESS_ID in", values, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotIn(List<String> values) {
            addCriterion("EXPRESS_ID not in", values, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdBetween(String value1, String value2) {
            addCriterion("EXPRESS_ID between", value1, value2, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotBetween(String value1, String value2) {
            addCriterion("EXPRESS_ID not between", value1, value2, "expressId");
            return (Criteria) this;
        }

        public Criteria andSendouttimeIsNull() {
            addCriterion("SENDOUTTIME is null");
            return (Criteria) this;
        }

        public Criteria andSendouttimeIsNotNull() {
            addCriterion("SENDOUTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendouttimeEqualTo(String value) {
            addCriterion("SENDOUTTIME =", value, "sendouttime");
            return (Criteria) this;
        }

        public Criteria andSendouttimeNotEqualTo(String value) {
            addCriterion("SENDOUTTIME <>", value, "sendouttime");
            return (Criteria) this;
        }

        public Criteria andSendouttimeGreaterThan(String value) {
            addCriterion("SENDOUTTIME >", value, "sendouttime");
            return (Criteria) this;
        }

        public Criteria andSendouttimeGreaterThanOrEqualTo(String value) {
            addCriterion("SENDOUTTIME >=", value, "sendouttime");
            return (Criteria) this;
        }

        public Criteria andSendouttimeLessThan(String value) {
            addCriterion("SENDOUTTIME <", value, "sendouttime");
            return (Criteria) this;
        }

        public Criteria andSendouttimeLessThanOrEqualTo(String value) {
            addCriterion("SENDOUTTIME <=", value, "sendouttime");
            return (Criteria) this;
        }

        public Criteria andSendouttimeLike(String value) {
            addCriterion("SENDOUTTIME like", value, "sendouttime");
            return (Criteria) this;
        }

        public Criteria andSendouttimeNotLike(String value) {
            addCriterion("SENDOUTTIME not like", value, "sendouttime");
            return (Criteria) this;
        }

        public Criteria andSendouttimeIn(List<String> values) {
            addCriterion("SENDOUTTIME in", values, "sendouttime");
            return (Criteria) this;
        }

        public Criteria andSendouttimeNotIn(List<String> values) {
            addCriterion("SENDOUTTIME not in", values, "sendouttime");
            return (Criteria) this;
        }

        public Criteria andSendouttimeBetween(String value1, String value2) {
            addCriterion("SENDOUTTIME between", value1, value2, "sendouttime");
            return (Criteria) this;
        }

        public Criteria andSendouttimeNotBetween(String value1, String value2) {
            addCriterion("SENDOUTTIME not between", value1, value2, "sendouttime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(String value) {
            addCriterion("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(String value) {
            addCriterion("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(String value) {
            addCriterion("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(String value) {
            addCriterion("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLike(String value) {
            addCriterion("UPDATETIME like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotLike(String value) {
            addCriterion("UPDATETIME not like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<String> values) {
            addCriterion("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<String> values) {
            addCriterion("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(String value1, String value2) {
            addCriterion("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andSLatitudeIsNull() {
            addCriterion("S_LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andSLatitudeIsNotNull() {
            addCriterion("S_LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andSLatitudeEqualTo(String value) {
            addCriterion("S_LATITUDE =", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeNotEqualTo(String value) {
            addCriterion("S_LATITUDE <>", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeGreaterThan(String value) {
            addCriterion("S_LATITUDE >", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("S_LATITUDE >=", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeLessThan(String value) {
            addCriterion("S_LATITUDE <", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeLessThanOrEqualTo(String value) {
            addCriterion("S_LATITUDE <=", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeLike(String value) {
            addCriterion("S_LATITUDE like", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeNotLike(String value) {
            addCriterion("S_LATITUDE not like", value, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeIn(List<String> values) {
            addCriterion("S_LATITUDE in", values, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeNotIn(List<String> values) {
            addCriterion("S_LATITUDE not in", values, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeBetween(String value1, String value2) {
            addCriterion("S_LATITUDE between", value1, value2, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLatitudeNotBetween(String value1, String value2) {
            addCriterion("S_LATITUDE not between", value1, value2, "sLatitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeIsNull() {
            addCriterion("S_LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andSLongitudeIsNotNull() {
            addCriterion("S_LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andSLongitudeEqualTo(String value) {
            addCriterion("S_LONGITUDE =", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeNotEqualTo(String value) {
            addCriterion("S_LONGITUDE <>", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeGreaterThan(String value) {
            addCriterion("S_LONGITUDE >", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("S_LONGITUDE >=", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeLessThan(String value) {
            addCriterion("S_LONGITUDE <", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeLessThanOrEqualTo(String value) {
            addCriterion("S_LONGITUDE <=", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeLike(String value) {
            addCriterion("S_LONGITUDE like", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeNotLike(String value) {
            addCriterion("S_LONGITUDE not like", value, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeIn(List<String> values) {
            addCriterion("S_LONGITUDE in", values, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeNotIn(List<String> values) {
            addCriterion("S_LONGITUDE not in", values, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeBetween(String value1, String value2) {
            addCriterion("S_LONGITUDE between", value1, value2, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andSLongitudeNotBetween(String value1, String value2) {
            addCriterion("S_LONGITUDE not between", value1, value2, "sLongitude");
            return (Criteria) this;
        }

        public Criteria andPLatitudeIsNull() {
            addCriterion("P_LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andPLatitudeIsNotNull() {
            addCriterion("P_LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andPLatitudeEqualTo(String value) {
            addCriterion("P_LATITUDE =", value, "pLatitude");
            return (Criteria) this;
        }

        public Criteria andPLatitudeNotEqualTo(String value) {
            addCriterion("P_LATITUDE <>", value, "pLatitude");
            return (Criteria) this;
        }

        public Criteria andPLatitudeGreaterThan(String value) {
            addCriterion("P_LATITUDE >", value, "pLatitude");
            return (Criteria) this;
        }

        public Criteria andPLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("P_LATITUDE >=", value, "pLatitude");
            return (Criteria) this;
        }

        public Criteria andPLatitudeLessThan(String value) {
            addCriterion("P_LATITUDE <", value, "pLatitude");
            return (Criteria) this;
        }

        public Criteria andPLatitudeLessThanOrEqualTo(String value) {
            addCriterion("P_LATITUDE <=", value, "pLatitude");
            return (Criteria) this;
        }

        public Criteria andPLatitudeLike(String value) {
            addCriterion("P_LATITUDE like", value, "pLatitude");
            return (Criteria) this;
        }

        public Criteria andPLatitudeNotLike(String value) {
            addCriterion("P_LATITUDE not like", value, "pLatitude");
            return (Criteria) this;
        }

        public Criteria andPLatitudeIn(List<String> values) {
            addCriterion("P_LATITUDE in", values, "pLatitude");
            return (Criteria) this;
        }

        public Criteria andPLatitudeNotIn(List<String> values) {
            addCriterion("P_LATITUDE not in", values, "pLatitude");
            return (Criteria) this;
        }

        public Criteria andPLatitudeBetween(String value1, String value2) {
            addCriterion("P_LATITUDE between", value1, value2, "pLatitude");
            return (Criteria) this;
        }

        public Criteria andPLatitudeNotBetween(String value1, String value2) {
            addCriterion("P_LATITUDE not between", value1, value2, "pLatitude");
            return (Criteria) this;
        }

        public Criteria andPLongitudeIsNull() {
            addCriterion("P_LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andPLongitudeIsNotNull() {
            addCriterion("P_LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andPLongitudeEqualTo(String value) {
            addCriterion("P_LONGITUDE =", value, "pLongitude");
            return (Criteria) this;
        }

        public Criteria andPLongitudeNotEqualTo(String value) {
            addCriterion("P_LONGITUDE <>", value, "pLongitude");
            return (Criteria) this;
        }

        public Criteria andPLongitudeGreaterThan(String value) {
            addCriterion("P_LONGITUDE >", value, "pLongitude");
            return (Criteria) this;
        }

        public Criteria andPLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("P_LONGITUDE >=", value, "pLongitude");
            return (Criteria) this;
        }

        public Criteria andPLongitudeLessThan(String value) {
            addCriterion("P_LONGITUDE <", value, "pLongitude");
            return (Criteria) this;
        }

        public Criteria andPLongitudeLessThanOrEqualTo(String value) {
            addCriterion("P_LONGITUDE <=", value, "pLongitude");
            return (Criteria) this;
        }

        public Criteria andPLongitudeLike(String value) {
            addCriterion("P_LONGITUDE like", value, "pLongitude");
            return (Criteria) this;
        }

        public Criteria andPLongitudeNotLike(String value) {
            addCriterion("P_LONGITUDE not like", value, "pLongitude");
            return (Criteria) this;
        }

        public Criteria andPLongitudeIn(List<String> values) {
            addCriterion("P_LONGITUDE in", values, "pLongitude");
            return (Criteria) this;
        }

        public Criteria andPLongitudeNotIn(List<String> values) {
            addCriterion("P_LONGITUDE not in", values, "pLongitude");
            return (Criteria) this;
        }

        public Criteria andPLongitudeBetween(String value1, String value2) {
            addCriterion("P_LONGITUDE between", value1, value2, "pLongitude");
            return (Criteria) this;
        }

        public Criteria andPLongitudeNotBetween(String value1, String value2) {
            addCriterion("P_LONGITUDE not between", value1, value2, "pLongitude");
            return (Criteria) this;
        }

        public Criteria andSenddescIsNull() {
            addCriterion("SENDDESC is null");
            return (Criteria) this;
        }

        public Criteria andSenddescIsNotNull() {
            addCriterion("SENDDESC is not null");
            return (Criteria) this;
        }

        public Criteria andSenddescEqualTo(String value) {
            addCriterion("SENDDESC =", value, "senddesc");
            return (Criteria) this;
        }

        public Criteria andSenddescNotEqualTo(String value) {
            addCriterion("SENDDESC <>", value, "senddesc");
            return (Criteria) this;
        }

        public Criteria andSenddescGreaterThan(String value) {
            addCriterion("SENDDESC >", value, "senddesc");
            return (Criteria) this;
        }

        public Criteria andSenddescGreaterThanOrEqualTo(String value) {
            addCriterion("SENDDESC >=", value, "senddesc");
            return (Criteria) this;
        }

        public Criteria andSenddescLessThan(String value) {
            addCriterion("SENDDESC <", value, "senddesc");
            return (Criteria) this;
        }

        public Criteria andSenddescLessThanOrEqualTo(String value) {
            addCriterion("SENDDESC <=", value, "senddesc");
            return (Criteria) this;
        }

        public Criteria andSenddescLike(String value) {
            addCriterion("SENDDESC like", value, "senddesc");
            return (Criteria) this;
        }

        public Criteria andSenddescNotLike(String value) {
            addCriterion("SENDDESC not like", value, "senddesc");
            return (Criteria) this;
        }

        public Criteria andSenddescIn(List<String> values) {
            addCriterion("SENDDESC in", values, "senddesc");
            return (Criteria) this;
        }

        public Criteria andSenddescNotIn(List<String> values) {
            addCriterion("SENDDESC not in", values, "senddesc");
            return (Criteria) this;
        }

        public Criteria andSenddescBetween(String value1, String value2) {
            addCriterion("SENDDESC between", value1, value2, "senddesc");
            return (Criteria) this;
        }

        public Criteria andSenddescNotBetween(String value1, String value2) {
            addCriterion("SENDDESC not between", value1, value2, "senddesc");
            return (Criteria) this;
        }

        public Criteria andFreightOldIsNull() {
            addCriterion("FREIGHT_OLD is null");
            return (Criteria) this;
        }

        public Criteria andFreightOldIsNotNull() {
            addCriterion("FREIGHT_OLD is not null");
            return (Criteria) this;
        }

        public Criteria andFreightOldEqualTo(BigDecimal value) {
            addCriterion("FREIGHT_OLD =", value, "freightOld");
            return (Criteria) this;
        }

        public Criteria andFreightOldNotEqualTo(BigDecimal value) {
            addCriterion("FREIGHT_OLD <>", value, "freightOld");
            return (Criteria) this;
        }

        public Criteria andFreightOldGreaterThan(BigDecimal value) {
            addCriterion("FREIGHT_OLD >", value, "freightOld");
            return (Criteria) this;
        }

        public Criteria andFreightOldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FREIGHT_OLD >=", value, "freightOld");
            return (Criteria) this;
        }

        public Criteria andFreightOldLessThan(BigDecimal value) {
            addCriterion("FREIGHT_OLD <", value, "freightOld");
            return (Criteria) this;
        }

        public Criteria andFreightOldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FREIGHT_OLD <=", value, "freightOld");
            return (Criteria) this;
        }

        public Criteria andFreightOldIn(List<BigDecimal> values) {
            addCriterion("FREIGHT_OLD in", values, "freightOld");
            return (Criteria) this;
        }

        public Criteria andFreightOldNotIn(List<BigDecimal> values) {
            addCriterion("FREIGHT_OLD not in", values, "freightOld");
            return (Criteria) this;
        }

        public Criteria andFreightOldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREIGHT_OLD between", value1, value2, "freightOld");
            return (Criteria) this;
        }

        public Criteria andFreightOldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREIGHT_OLD not between", value1, value2, "freightOld");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeIsNull() {
            addCriterion("CONT_PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeIsNotNull() {
            addCriterion("CONT_PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeEqualTo(String value) {
            addCriterion("CONT_PROVINCE_CODE =", value, "contProvinceCode");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeNotEqualTo(String value) {
            addCriterion("CONT_PROVINCE_CODE <>", value, "contProvinceCode");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeGreaterThan(String value) {
            addCriterion("CONT_PROVINCE_CODE >", value, "contProvinceCode");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_PROVINCE_CODE >=", value, "contProvinceCode");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeLessThan(String value) {
            addCriterion("CONT_PROVINCE_CODE <", value, "contProvinceCode");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("CONT_PROVINCE_CODE <=", value, "contProvinceCode");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeLike(String value) {
            addCriterion("CONT_PROVINCE_CODE like", value, "contProvinceCode");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeNotLike(String value) {
            addCriterion("CONT_PROVINCE_CODE not like", value, "contProvinceCode");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeIn(List<String> values) {
            addCriterion("CONT_PROVINCE_CODE in", values, "contProvinceCode");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeNotIn(List<String> values) {
            addCriterion("CONT_PROVINCE_CODE not in", values, "contProvinceCode");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeBetween(String value1, String value2) {
            addCriterion("CONT_PROVINCE_CODE between", value1, value2, "contProvinceCode");
            return (Criteria) this;
        }

        public Criteria andContProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("CONT_PROVINCE_CODE not between", value1, value2, "contProvinceCode");
            return (Criteria) this;
        }

        public Criteria andContCityCodeIsNull() {
            addCriterion("CONT_CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andContCityCodeIsNotNull() {
            addCriterion("CONT_CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andContCityCodeEqualTo(String value) {
            addCriterion("CONT_CITY_CODE =", value, "contCityCode");
            return (Criteria) this;
        }

        public Criteria andContCityCodeNotEqualTo(String value) {
            addCriterion("CONT_CITY_CODE <>", value, "contCityCode");
            return (Criteria) this;
        }

        public Criteria andContCityCodeGreaterThan(String value) {
            addCriterion("CONT_CITY_CODE >", value, "contCityCode");
            return (Criteria) this;
        }

        public Criteria andContCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_CITY_CODE >=", value, "contCityCode");
            return (Criteria) this;
        }

        public Criteria andContCityCodeLessThan(String value) {
            addCriterion("CONT_CITY_CODE <", value, "contCityCode");
            return (Criteria) this;
        }

        public Criteria andContCityCodeLessThanOrEqualTo(String value) {
            addCriterion("CONT_CITY_CODE <=", value, "contCityCode");
            return (Criteria) this;
        }

        public Criteria andContCityCodeLike(String value) {
            addCriterion("CONT_CITY_CODE like", value, "contCityCode");
            return (Criteria) this;
        }

        public Criteria andContCityCodeNotLike(String value) {
            addCriterion("CONT_CITY_CODE not like", value, "contCityCode");
            return (Criteria) this;
        }

        public Criteria andContCityCodeIn(List<String> values) {
            addCriterion("CONT_CITY_CODE in", values, "contCityCode");
            return (Criteria) this;
        }

        public Criteria andContCityCodeNotIn(List<String> values) {
            addCriterion("CONT_CITY_CODE not in", values, "contCityCode");
            return (Criteria) this;
        }

        public Criteria andContCityCodeBetween(String value1, String value2) {
            addCriterion("CONT_CITY_CODE between", value1, value2, "contCityCode");
            return (Criteria) this;
        }

        public Criteria andContCityCodeNotBetween(String value1, String value2) {
            addCriterion("CONT_CITY_CODE not between", value1, value2, "contCityCode");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeIsNull() {
            addCriterion("CONT_DISTRICT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeIsNotNull() {
            addCriterion("CONT_DISTRICT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeEqualTo(String value) {
            addCriterion("CONT_DISTRICT_CODE =", value, "contDistrictCode");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeNotEqualTo(String value) {
            addCriterion("CONT_DISTRICT_CODE <>", value, "contDistrictCode");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeGreaterThan(String value) {
            addCriterion("CONT_DISTRICT_CODE >", value, "contDistrictCode");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CONT_DISTRICT_CODE >=", value, "contDistrictCode");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeLessThan(String value) {
            addCriterion("CONT_DISTRICT_CODE <", value, "contDistrictCode");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeLessThanOrEqualTo(String value) {
            addCriterion("CONT_DISTRICT_CODE <=", value, "contDistrictCode");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeLike(String value) {
            addCriterion("CONT_DISTRICT_CODE like", value, "contDistrictCode");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeNotLike(String value) {
            addCriterion("CONT_DISTRICT_CODE not like", value, "contDistrictCode");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeIn(List<String> values) {
            addCriterion("CONT_DISTRICT_CODE in", values, "contDistrictCode");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeNotIn(List<String> values) {
            addCriterion("CONT_DISTRICT_CODE not in", values, "contDistrictCode");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeBetween(String value1, String value2) {
            addCriterion("CONT_DISTRICT_CODE between", value1, value2, "contDistrictCode");
            return (Criteria) this;
        }

        public Criteria andContDistrictCodeNotBetween(String value1, String value2) {
            addCriterion("CONT_DISTRICT_CODE not between", value1, value2, "contDistrictCode");
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