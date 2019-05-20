package com.xzb.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InnerLetterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InnerLetterExample() {
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

        public Criteria andFormpersonIsNull() {
            addCriterion("formperson is null");
            return (Criteria) this;
        }

        public Criteria andFormpersonIsNotNull() {
            addCriterion("formperson is not null");
            return (Criteria) this;
        }

        public Criteria andFormpersonEqualTo(String value) {
            addCriterion("formperson =", value, "formperson");
            return (Criteria) this;
        }

        public Criteria andFormpersonNotEqualTo(String value) {
            addCriterion("formperson <>", value, "formperson");
            return (Criteria) this;
        }

        public Criteria andFormpersonGreaterThan(String value) {
            addCriterion("formperson >", value, "formperson");
            return (Criteria) this;
        }

        public Criteria andFormpersonGreaterThanOrEqualTo(String value) {
            addCriterion("formperson >=", value, "formperson");
            return (Criteria) this;
        }

        public Criteria andFormpersonLessThan(String value) {
            addCriterion("formperson <", value, "formperson");
            return (Criteria) this;
        }

        public Criteria andFormpersonLessThanOrEqualTo(String value) {
            addCriterion("formperson <=", value, "formperson");
            return (Criteria) this;
        }

        public Criteria andFormpersonLike(String value) {
            addCriterion("formperson like", value, "formperson");
            return (Criteria) this;
        }

        public Criteria andFormpersonNotLike(String value) {
            addCriterion("formperson not like", value, "formperson");
            return (Criteria) this;
        }

        public Criteria andFormpersonIn(List<String> values) {
            addCriterion("formperson in", values, "formperson");
            return (Criteria) this;
        }

        public Criteria andFormpersonNotIn(List<String> values) {
            addCriterion("formperson not in", values, "formperson");
            return (Criteria) this;
        }

        public Criteria andFormpersonBetween(String value1, String value2) {
            addCriterion("formperson between", value1, value2, "formperson");
            return (Criteria) this;
        }

        public Criteria andFormpersonNotBetween(String value1, String value2) {
            addCriterion("formperson not between", value1, value2, "formperson");
            return (Criteria) this;
        }

        public Criteria andTopersonIsNull() {
            addCriterion("toperson is null");
            return (Criteria) this;
        }

        public Criteria andTopersonIsNotNull() {
            addCriterion("toperson is not null");
            return (Criteria) this;
        }

        public Criteria andTopersonEqualTo(String value) {
            addCriterion("toperson =", value, "toperson");
            return (Criteria) this;
        }

        public Criteria andTopersonNotEqualTo(String value) {
            addCriterion("toperson <>", value, "toperson");
            return (Criteria) this;
        }

        public Criteria andTopersonGreaterThan(String value) {
            addCriterion("toperson >", value, "toperson");
            return (Criteria) this;
        }

        public Criteria andTopersonGreaterThanOrEqualTo(String value) {
            addCriterion("toperson >=", value, "toperson");
            return (Criteria) this;
        }

        public Criteria andTopersonLessThan(String value) {
            addCriterion("toperson <", value, "toperson");
            return (Criteria) this;
        }

        public Criteria andTopersonLessThanOrEqualTo(String value) {
            addCriterion("toperson <=", value, "toperson");
            return (Criteria) this;
        }

        public Criteria andTopersonLike(String value) {
            addCriterion("toperson like", value, "toperson");
            return (Criteria) this;
        }

        public Criteria andTopersonNotLike(String value) {
            addCriterion("toperson not like", value, "toperson");
            return (Criteria) this;
        }

        public Criteria andTopersonIn(List<String> values) {
            addCriterion("toperson in", values, "toperson");
            return (Criteria) this;
        }

        public Criteria andTopersonNotIn(List<String> values) {
            addCriterion("toperson not in", values, "toperson");
            return (Criteria) this;
        }

        public Criteria andTopersonBetween(String value1, String value2) {
            addCriterion("toperson between", value1, value2, "toperson");
            return (Criteria) this;
        }

        public Criteria andTopersonNotBetween(String value1, String value2) {
            addCriterion("toperson not between", value1, value2, "toperson");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andLettercodeIsNull() {
            addCriterion("lettercode is null");
            return (Criteria) this;
        }

        public Criteria andLettercodeIsNotNull() {
            addCriterion("lettercode is not null");
            return (Criteria) this;
        }

        public Criteria andLettercodeEqualTo(Integer value) {
            addCriterion("lettercode =", value, "lettercode");
            return (Criteria) this;
        }

        public Criteria andLettercodeNotEqualTo(Integer value) {
            addCriterion("lettercode <>", value, "lettercode");
            return (Criteria) this;
        }

        public Criteria andLettercodeGreaterThan(Integer value) {
            addCriterion("lettercode >", value, "lettercode");
            return (Criteria) this;
        }

        public Criteria andLettercodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lettercode >=", value, "lettercode");
            return (Criteria) this;
        }

        public Criteria andLettercodeLessThan(Integer value) {
            addCriterion("lettercode <", value, "lettercode");
            return (Criteria) this;
        }

        public Criteria andLettercodeLessThanOrEqualTo(Integer value) {
            addCriterion("lettercode <=", value, "lettercode");
            return (Criteria) this;
        }

        public Criteria andLettercodeIn(List<Integer> values) {
            addCriterion("lettercode in", values, "lettercode");
            return (Criteria) this;
        }

        public Criteria andLettercodeNotIn(List<Integer> values) {
            addCriterion("lettercode not in", values, "lettercode");
            return (Criteria) this;
        }

        public Criteria andLettercodeBetween(Integer value1, Integer value2) {
            addCriterion("lettercode between", value1, value2, "lettercode");
            return (Criteria) this;
        }

        public Criteria andLettercodeNotBetween(Integer value1, Integer value2) {
            addCriterion("lettercode not between", value1, value2, "lettercode");
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