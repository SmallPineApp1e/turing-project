package com.turing.turing.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HistoryExample() {
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

        public Criteria andHisIdIsNull() {
            addCriterion("his_id is null");
            return (Criteria) this;
        }

        public Criteria andHisIdIsNotNull() {
            addCriterion("his_id is not null");
            return (Criteria) this;
        }

        public Criteria andHisIdEqualTo(Integer value) {
            addCriterion("his_id =", value, "hisId");
            return (Criteria) this;
        }

        public Criteria andHisIdNotEqualTo(Integer value) {
            addCriterion("his_id <>", value, "hisId");
            return (Criteria) this;
        }

        public Criteria andHisIdGreaterThan(Integer value) {
            addCriterion("his_id >", value, "hisId");
            return (Criteria) this;
        }

        public Criteria andHisIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("his_id >=", value, "hisId");
            return (Criteria) this;
        }

        public Criteria andHisIdLessThan(Integer value) {
            addCriterion("his_id <", value, "hisId");
            return (Criteria) this;
        }

        public Criteria andHisIdLessThanOrEqualTo(Integer value) {
            addCriterion("his_id <=", value, "hisId");
            return (Criteria) this;
        }

        public Criteria andHisIdIn(List<Integer> values) {
            addCriterion("his_id in", values, "hisId");
            return (Criteria) this;
        }

        public Criteria andHisIdNotIn(List<Integer> values) {
            addCriterion("his_id not in", values, "hisId");
            return (Criteria) this;
        }

        public Criteria andHisIdBetween(Integer value1, Integer value2) {
            addCriterion("his_id between", value1, value2, "hisId");
            return (Criteria) this;
        }

        public Criteria andHisIdNotBetween(Integer value1, Integer value2) {
            addCriterion("his_id not between", value1, value2, "hisId");
            return (Criteria) this;
        }

        public Criteria andHisInfoIsNull() {
            addCriterion("his_info is null");
            return (Criteria) this;
        }

        public Criteria andHisInfoIsNotNull() {
            addCriterion("his_info is not null");
            return (Criteria) this;
        }

        public Criteria andHisInfoEqualTo(String value) {
            addCriterion("his_info =", value, "hisInfo");
            return (Criteria) this;
        }

        public Criteria andHisInfoNotEqualTo(String value) {
            addCriterion("his_info <>", value, "hisInfo");
            return (Criteria) this;
        }

        public Criteria andHisInfoGreaterThan(String value) {
            addCriterion("his_info >", value, "hisInfo");
            return (Criteria) this;
        }

        public Criteria andHisInfoGreaterThanOrEqualTo(String value) {
            addCriterion("his_info >=", value, "hisInfo");
            return (Criteria) this;
        }

        public Criteria andHisInfoLessThan(String value) {
            addCriterion("his_info <", value, "hisInfo");
            return (Criteria) this;
        }

        public Criteria andHisInfoLessThanOrEqualTo(String value) {
            addCriterion("his_info <=", value, "hisInfo");
            return (Criteria) this;
        }

        public Criteria andHisInfoLike(String value) {
            addCriterion("his_info like", value, "hisInfo");
            return (Criteria) this;
        }

        public Criteria andHisInfoNotLike(String value) {
            addCriterion("his_info not like", value, "hisInfo");
            return (Criteria) this;
        }

        public Criteria andHisInfoIn(List<String> values) {
            addCriterion("his_info in", values, "hisInfo");
            return (Criteria) this;
        }

        public Criteria andHisInfoNotIn(List<String> values) {
            addCriterion("his_info not in", values, "hisInfo");
            return (Criteria) this;
        }

        public Criteria andHisInfoBetween(String value1, String value2) {
            addCriterion("his_info between", value1, value2, "hisInfo");
            return (Criteria) this;
        }

        public Criteria andHisInfoNotBetween(String value1, String value2) {
            addCriterion("his_info not between", value1, value2, "hisInfo");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNull() {
            addCriterion("edit_time is null");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNotNull() {
            addCriterion("edit_time is not null");
            return (Criteria) this;
        }

        public Criteria andEditTimeEqualTo(Date value) {
            addCriterion("edit_time =", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotEqualTo(Date value) {
            addCriterion("edit_time <>", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThan(Date value) {
            addCriterion("edit_time >", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("edit_time >=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThan(Date value) {
            addCriterion("edit_time <", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThanOrEqualTo(Date value) {
            addCriterion("edit_time <=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeIn(List<Date> values) {
            addCriterion("edit_time in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotIn(List<Date> values) {
            addCriterion("edit_time not in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeBetween(Date value1, Date value2) {
            addCriterion("edit_time between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotBetween(Date value1, Date value2) {
            addCriterion("edit_time not between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditNameIsNull() {
            addCriterion("edit_name is null");
            return (Criteria) this;
        }

        public Criteria andEditNameIsNotNull() {
            addCriterion("edit_name is not null");
            return (Criteria) this;
        }

        public Criteria andEditNameEqualTo(String value) {
            addCriterion("edit_name =", value, "editName");
            return (Criteria) this;
        }

        public Criteria andEditNameNotEqualTo(String value) {
            addCriterion("edit_name <>", value, "editName");
            return (Criteria) this;
        }

        public Criteria andEditNameGreaterThan(String value) {
            addCriterion("edit_name >", value, "editName");
            return (Criteria) this;
        }

        public Criteria andEditNameGreaterThanOrEqualTo(String value) {
            addCriterion("edit_name >=", value, "editName");
            return (Criteria) this;
        }

        public Criteria andEditNameLessThan(String value) {
            addCriterion("edit_name <", value, "editName");
            return (Criteria) this;
        }

        public Criteria andEditNameLessThanOrEqualTo(String value) {
            addCriterion("edit_name <=", value, "editName");
            return (Criteria) this;
        }

        public Criteria andEditNameLike(String value) {
            addCriterion("edit_name like", value, "editName");
            return (Criteria) this;
        }

        public Criteria andEditNameNotLike(String value) {
            addCriterion("edit_name not like", value, "editName");
            return (Criteria) this;
        }

        public Criteria andEditNameIn(List<String> values) {
            addCriterion("edit_name in", values, "editName");
            return (Criteria) this;
        }

        public Criteria andEditNameNotIn(List<String> values) {
            addCriterion("edit_name not in", values, "editName");
            return (Criteria) this;
        }

        public Criteria andEditNameBetween(String value1, String value2) {
            addCriterion("edit_name between", value1, value2, "editName");
            return (Criteria) this;
        }

        public Criteria andEditNameNotBetween(String value1, String value2) {
            addCriterion("edit_name not between", value1, value2, "editName");
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