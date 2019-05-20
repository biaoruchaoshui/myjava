package com.xzb.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LostExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPickDateIsNull() {
            addCriterion("pickDate is null");
            return (Criteria) this;
        }

        public Criteria andPickDateIsNotNull() {
            addCriterion("pickDate is not null");
            return (Criteria) this;
        }

        public Criteria andPickDateEqualTo(Date value) {
            addCriterion("pickDate =", value, "pickDate");
            return (Criteria) this;
        }

        public Criteria andPickDateNotEqualTo(Date value) {
            addCriterion("pickDate <>", value, "pickDate");
            return (Criteria) this;
        }

        public Criteria andPickDateGreaterThan(Date value) {
            addCriterion("pickDate >", value, "pickDate");
            return (Criteria) this;
        }

        public Criteria andPickDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pickDate >=", value, "pickDate");
            return (Criteria) this;
        }

        public Criteria andPickDateLessThan(Date value) {
            addCriterion("pickDate <", value, "pickDate");
            return (Criteria) this;
        }

        public Criteria andPickDateLessThanOrEqualTo(Date value) {
            addCriterion("pickDate <=", value, "pickDate");
            return (Criteria) this;
        }

        public Criteria andPickDateIn(List<Date> values) {
            addCriterion("pickDate in", values, "pickDate");
            return (Criteria) this;
        }

        public Criteria andPickDateNotIn(List<Date> values) {
            addCriterion("pickDate not in", values, "pickDate");
            return (Criteria) this;
        }

        public Criteria andPickDateBetween(Date value1, Date value2) {
            addCriterion("pickDate between", value1, value2, "pickDate");
            return (Criteria) this;
        }

        public Criteria andPickDateNotBetween(Date value1, Date value2) {
            addCriterion("pickDate not between", value1, value2, "pickDate");
            return (Criteria) this;
        }

        public Criteria andPickpersonIsNull() {
            addCriterion("pickperson is null");
            return (Criteria) this;
        }

        public Criteria andPickpersonIsNotNull() {
            addCriterion("pickperson is not null");
            return (Criteria) this;
        }

        public Criteria andPickpersonEqualTo(String value) {
            addCriterion("pickperson =", value, "pickperson");
            return (Criteria) this;
        }

        public Criteria andPickpersonNotEqualTo(String value) {
            addCriterion("pickperson <>", value, "pickperson");
            return (Criteria) this;
        }

        public Criteria andPickpersonGreaterThan(String value) {
            addCriterion("pickperson >", value, "pickperson");
            return (Criteria) this;
        }

        public Criteria andPickpersonGreaterThanOrEqualTo(String value) {
            addCriterion("pickperson >=", value, "pickperson");
            return (Criteria) this;
        }

        public Criteria andPickpersonLessThan(String value) {
            addCriterion("pickperson <", value, "pickperson");
            return (Criteria) this;
        }

        public Criteria andPickpersonLessThanOrEqualTo(String value) {
            addCriterion("pickperson <=", value, "pickperson");
            return (Criteria) this;
        }

        public Criteria andPickpersonLike(String value) {
            addCriterion("pickperson like", value, "pickperson");
            return (Criteria) this;
        }

        public Criteria andPickpersonNotLike(String value) {
            addCriterion("pickperson not like", value, "pickperson");
            return (Criteria) this;
        }

        public Criteria andPickpersonIn(List<String> values) {
            addCriterion("pickperson in", values, "pickperson");
            return (Criteria) this;
        }

        public Criteria andPickpersonNotIn(List<String> values) {
            addCriterion("pickperson not in", values, "pickperson");
            return (Criteria) this;
        }

        public Criteria andPickpersonBetween(String value1, String value2) {
            addCriterion("pickperson between", value1, value2, "pickperson");
            return (Criteria) this;
        }

        public Criteria andPickpersonNotBetween(String value1, String value2) {
            addCriterion("pickperson not between", value1, value2, "pickperson");
            return (Criteria) this;
        }

        public Criteria andPickplaceIsNull() {
            addCriterion("pickplace is null");
            return (Criteria) this;
        }

        public Criteria andPickplaceIsNotNull() {
            addCriterion("pickplace is not null");
            return (Criteria) this;
        }

        public Criteria andPickplaceEqualTo(String value) {
            addCriterion("pickplace =", value, "pickplace");
            return (Criteria) this;
        }

        public Criteria andPickplaceNotEqualTo(String value) {
            addCriterion("pickplace <>", value, "pickplace");
            return (Criteria) this;
        }

        public Criteria andPickplaceGreaterThan(String value) {
            addCriterion("pickplace >", value, "pickplace");
            return (Criteria) this;
        }

        public Criteria andPickplaceGreaterThanOrEqualTo(String value) {
            addCriterion("pickplace >=", value, "pickplace");
            return (Criteria) this;
        }

        public Criteria andPickplaceLessThan(String value) {
            addCriterion("pickplace <", value, "pickplace");
            return (Criteria) this;
        }

        public Criteria andPickplaceLessThanOrEqualTo(String value) {
            addCriterion("pickplace <=", value, "pickplace");
            return (Criteria) this;
        }

        public Criteria andPickplaceLike(String value) {
            addCriterion("pickplace like", value, "pickplace");
            return (Criteria) this;
        }

        public Criteria andPickplaceNotLike(String value) {
            addCriterion("pickplace not like", value, "pickplace");
            return (Criteria) this;
        }

        public Criteria andPickplaceIn(List<String> values) {
            addCriterion("pickplace in", values, "pickplace");
            return (Criteria) this;
        }

        public Criteria andPickplaceNotIn(List<String> values) {
            addCriterion("pickplace not in", values, "pickplace");
            return (Criteria) this;
        }

        public Criteria andPickplaceBetween(String value1, String value2) {
            addCriterion("pickplace between", value1, value2, "pickplace");
            return (Criteria) this;
        }

        public Criteria andPickplaceNotBetween(String value1, String value2) {
            addCriterion("pickplace not between", value1, value2, "pickplace");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(Integer value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(Integer value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(Integer value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(Integer value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(Integer value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<Integer> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<Integer> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(Integer value1, Integer value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andClaimpersonIsNull() {
            addCriterion("claimperson is null");
            return (Criteria) this;
        }

        public Criteria andClaimpersonIsNotNull() {
            addCriterion("claimperson is not null");
            return (Criteria) this;
        }

        public Criteria andClaimpersonEqualTo(String value) {
            addCriterion("claimperson =", value, "claimperson");
            return (Criteria) this;
        }

        public Criteria andClaimpersonNotEqualTo(String value) {
            addCriterion("claimperson <>", value, "claimperson");
            return (Criteria) this;
        }

        public Criteria andClaimpersonGreaterThan(String value) {
            addCriterion("claimperson >", value, "claimperson");
            return (Criteria) this;
        }

        public Criteria andClaimpersonGreaterThanOrEqualTo(String value) {
            addCriterion("claimperson >=", value, "claimperson");
            return (Criteria) this;
        }

        public Criteria andClaimpersonLessThan(String value) {
            addCriterion("claimperson <", value, "claimperson");
            return (Criteria) this;
        }

        public Criteria andClaimpersonLessThanOrEqualTo(String value) {
            addCriterion("claimperson <=", value, "claimperson");
            return (Criteria) this;
        }

        public Criteria andClaimpersonLike(String value) {
            addCriterion("claimperson like", value, "claimperson");
            return (Criteria) this;
        }

        public Criteria andClaimpersonNotLike(String value) {
            addCriterion("claimperson not like", value, "claimperson");
            return (Criteria) this;
        }

        public Criteria andClaimpersonIn(List<String> values) {
            addCriterion("claimperson in", values, "claimperson");
            return (Criteria) this;
        }

        public Criteria andClaimpersonNotIn(List<String> values) {
            addCriterion("claimperson not in", values, "claimperson");
            return (Criteria) this;
        }

        public Criteria andClaimpersonBetween(String value1, String value2) {
            addCriterion("claimperson between", value1, value2, "claimperson");
            return (Criteria) this;
        }

        public Criteria andClaimpersonNotBetween(String value1, String value2) {
            addCriterion("claimperson not between", value1, value2, "claimperson");
            return (Criteria) this;
        }

        public Criteria andClaimdateIsNull() {
            addCriterion("claimdate is null");
            return (Criteria) this;
        }

        public Criteria andClaimdateIsNotNull() {
            addCriterion("claimdate is not null");
            return (Criteria) this;
        }

        public Criteria andClaimdateEqualTo(Date value) {
            addCriterion("claimdate =", value, "claimdate");
            return (Criteria) this;
        }

        public Criteria andClaimdateNotEqualTo(Date value) {
            addCriterion("claimdate <>", value, "claimdate");
            return (Criteria) this;
        }

        public Criteria andClaimdateGreaterThan(Date value) {
            addCriterion("claimdate >", value, "claimdate");
            return (Criteria) this;
        }

        public Criteria andClaimdateGreaterThanOrEqualTo(Date value) {
            addCriterion("claimdate >=", value, "claimdate");
            return (Criteria) this;
        }

        public Criteria andClaimdateLessThan(Date value) {
            addCriterion("claimdate <", value, "claimdate");
            return (Criteria) this;
        }

        public Criteria andClaimdateLessThanOrEqualTo(Date value) {
            addCriterion("claimdate <=", value, "claimdate");
            return (Criteria) this;
        }

        public Criteria andClaimdateIn(List<Date> values) {
            addCriterion("claimdate in", values, "claimdate");
            return (Criteria) this;
        }

        public Criteria andClaimdateNotIn(List<Date> values) {
            addCriterion("claimdate not in", values, "claimdate");
            return (Criteria) this;
        }

        public Criteria andClaimdateBetween(Date value1, Date value2) {
            addCriterion("claimdate between", value1, value2, "claimdate");
            return (Criteria) this;
        }

        public Criteria andClaimdateNotBetween(Date value1, Date value2) {
            addCriterion("claimdate not between", value1, value2, "claimdate");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
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