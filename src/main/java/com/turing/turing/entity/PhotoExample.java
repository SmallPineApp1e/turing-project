package com.turing.turing.entity;

import java.util.ArrayList;
import java.util.List;

public class PhotoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PhotoExample() {
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

        public Criteria andPhotoIdIsNull() {
            addCriterion("photo_id is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIsNotNull() {
            addCriterion("photo_id is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdEqualTo(Integer value) {
            addCriterion("photo_id =", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotEqualTo(Integer value) {
            addCriterion("photo_id <>", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThan(Integer value) {
            addCriterion("photo_id >", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("photo_id >=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThan(Integer value) {
            addCriterion("photo_id <", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThanOrEqualTo(Integer value) {
            addCriterion("photo_id <=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIn(List<Integer> values) {
            addCriterion("photo_id in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotIn(List<Integer> values) {
            addCriterion("photo_id not in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdBetween(Integer value1, Integer value2) {
            addCriterion("photo_id between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("photo_id not between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoLocIsNull() {
            addCriterion("photo_loc is null");
            return (Criteria) this;
        }

        public Criteria andPhotoLocIsNotNull() {
            addCriterion("photo_loc is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoLocEqualTo(String value) {
            addCriterion("photo_loc =", value, "photoLoc");
            return (Criteria) this;
        }

        public Criteria andPhotoLocNotEqualTo(String value) {
            addCriterion("photo_loc <>", value, "photoLoc");
            return (Criteria) this;
        }

        public Criteria andPhotoLocGreaterThan(String value) {
            addCriterion("photo_loc >", value, "photoLoc");
            return (Criteria) this;
        }

        public Criteria andPhotoLocGreaterThanOrEqualTo(String value) {
            addCriterion("photo_loc >=", value, "photoLoc");
            return (Criteria) this;
        }

        public Criteria andPhotoLocLessThan(String value) {
            addCriterion("photo_loc <", value, "photoLoc");
            return (Criteria) this;
        }

        public Criteria andPhotoLocLessThanOrEqualTo(String value) {
            addCriterion("photo_loc <=", value, "photoLoc");
            return (Criteria) this;
        }

        public Criteria andPhotoLocLike(String value) {
            addCriterion("photo_loc like", value, "photoLoc");
            return (Criteria) this;
        }

        public Criteria andPhotoLocNotLike(String value) {
            addCriterion("photo_loc not like", value, "photoLoc");
            return (Criteria) this;
        }

        public Criteria andPhotoLocIn(List<String> values) {
            addCriterion("photo_loc in", values, "photoLoc");
            return (Criteria) this;
        }

        public Criteria andPhotoLocNotIn(List<String> values) {
            addCriterion("photo_loc not in", values, "photoLoc");
            return (Criteria) this;
        }

        public Criteria andPhotoLocBetween(String value1, String value2) {
            addCriterion("photo_loc between", value1, value2, "photoLoc");
            return (Criteria) this;
        }

        public Criteria andPhotoLocNotBetween(String value1, String value2) {
            addCriterion("photo_loc not between", value1, value2, "photoLoc");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeIsNull() {
            addCriterion("photo_type is null");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeIsNotNull() {
            addCriterion("photo_type is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeEqualTo(String value) {
            addCriterion("photo_type =", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeNotEqualTo(String value) {
            addCriterion("photo_type <>", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeGreaterThan(String value) {
            addCriterion("photo_type >", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("photo_type >=", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeLessThan(String value) {
            addCriterion("photo_type <", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeLessThanOrEqualTo(String value) {
            addCriterion("photo_type <=", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeLike(String value) {
            addCriterion("photo_type like", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeNotLike(String value) {
            addCriterion("photo_type not like", value, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeIn(List<String> values) {
            addCriterion("photo_type in", values, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeNotIn(List<String> values) {
            addCriterion("photo_type not in", values, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeBetween(String value1, String value2) {
            addCriterion("photo_type between", value1, value2, "photoType");
            return (Criteria) this;
        }

        public Criteria andPhotoTypeNotBetween(String value1, String value2) {
            addCriterion("photo_type not between", value1, value2, "photoType");
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