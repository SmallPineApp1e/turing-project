package com.turing.turing.entity;

import java.util.ArrayList;
import java.util.List;

public class LiveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LiveExample() {
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

        public Criteria andLiveIdIsNull() {
            addCriterion("live_id is null");
            return (Criteria) this;
        }

        public Criteria andLiveIdIsNotNull() {
            addCriterion("live_id is not null");
            return (Criteria) this;
        }

        public Criteria andLiveIdEqualTo(Integer value) {
            addCriterion("live_id =", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdNotEqualTo(Integer value) {
            addCriterion("live_id <>", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdGreaterThan(Integer value) {
            addCriterion("live_id >", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("live_id >=", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdLessThan(Integer value) {
            addCriterion("live_id <", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("live_id <=", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdIn(List<Integer> values) {
            addCriterion("live_id in", values, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdNotIn(List<Integer> values) {
            addCriterion("live_id not in", values, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdBetween(Integer value1, Integer value2) {
            addCriterion("live_id between", value1, value2, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("live_id not between", value1, value2, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveNameIsNull() {
            addCriterion("live_name is null");
            return (Criteria) this;
        }

        public Criteria andLiveNameIsNotNull() {
            addCriterion("live_name is not null");
            return (Criteria) this;
        }

        public Criteria andLiveNameEqualTo(String value) {
            addCriterion("live_name =", value, "liveName");
            return (Criteria) this;
        }

        public Criteria andLiveNameNotEqualTo(String value) {
            addCriterion("live_name <>", value, "liveName");
            return (Criteria) this;
        }

        public Criteria andLiveNameGreaterThan(String value) {
            addCriterion("live_name >", value, "liveName");
            return (Criteria) this;
        }

        public Criteria andLiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("live_name >=", value, "liveName");
            return (Criteria) this;
        }

        public Criteria andLiveNameLessThan(String value) {
            addCriterion("live_name <", value, "liveName");
            return (Criteria) this;
        }

        public Criteria andLiveNameLessThanOrEqualTo(String value) {
            addCriterion("live_name <=", value, "liveName");
            return (Criteria) this;
        }

        public Criteria andLiveNameLike(String value) {
            addCriterion("live_name like", value, "liveName");
            return (Criteria) this;
        }

        public Criteria andLiveNameNotLike(String value) {
            addCriterion("live_name not like", value, "liveName");
            return (Criteria) this;
        }

        public Criteria andLiveNameIn(List<String> values) {
            addCriterion("live_name in", values, "liveName");
            return (Criteria) this;
        }

        public Criteria andLiveNameNotIn(List<String> values) {
            addCriterion("live_name not in", values, "liveName");
            return (Criteria) this;
        }

        public Criteria andLiveNameBetween(String value1, String value2) {
            addCriterion("live_name between", value1, value2, "liveName");
            return (Criteria) this;
        }

        public Criteria andLiveNameNotBetween(String value1, String value2) {
            addCriterion("live_name not between", value1, value2, "liveName");
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