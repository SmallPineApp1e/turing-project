package com.turing.turing.entity;

import java.util.ArrayList;
import java.util.List;

public class ResumeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResumeExample() {
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

        public Criteria andResuIdIsNull() {
            addCriterion("resu_id is null");
            return (Criteria) this;
        }

        public Criteria andResuIdIsNotNull() {
            addCriterion("resu_id is not null");
            return (Criteria) this;
        }

        public Criteria andResuIdEqualTo(Integer value) {
            addCriterion("resu_id =", value, "resuId");
            return (Criteria) this;
        }

        public Criteria andResuIdNotEqualTo(Integer value) {
            addCriterion("resu_id <>", value, "resuId");
            return (Criteria) this;
        }

        public Criteria andResuIdGreaterThan(Integer value) {
            addCriterion("resu_id >", value, "resuId");
            return (Criteria) this;
        }

        public Criteria andResuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("resu_id >=", value, "resuId");
            return (Criteria) this;
        }

        public Criteria andResuIdLessThan(Integer value) {
            addCriterion("resu_id <", value, "resuId");
            return (Criteria) this;
        }

        public Criteria andResuIdLessThanOrEqualTo(Integer value) {
            addCriterion("resu_id <=", value, "resuId");
            return (Criteria) this;
        }

        public Criteria andResuIdIn(List<Integer> values) {
            addCriterion("resu_id in", values, "resuId");
            return (Criteria) this;
        }

        public Criteria andResuIdNotIn(List<Integer> values) {
            addCriterion("resu_id not in", values, "resuId");
            return (Criteria) this;
        }

        public Criteria andResuIdBetween(Integer value1, Integer value2) {
            addCriterion("resu_id between", value1, value2, "resuId");
            return (Criteria) this;
        }

        public Criteria andResuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("resu_id not between", value1, value2, "resuId");
            return (Criteria) this;
        }

        public Criteria andResuNameIsNull() {
            addCriterion("resu_name is null");
            return (Criteria) this;
        }

        public Criteria andResuNameIsNotNull() {
            addCriterion("resu_name is not null");
            return (Criteria) this;
        }

        public Criteria andResuNameEqualTo(String value) {
            addCriterion("resu_name =", value, "resuName");
            return (Criteria) this;
        }

        public Criteria andResuNameNotEqualTo(String value) {
            addCriterion("resu_name <>", value, "resuName");
            return (Criteria) this;
        }

        public Criteria andResuNameGreaterThan(String value) {
            addCriterion("resu_name >", value, "resuName");
            return (Criteria) this;
        }

        public Criteria andResuNameGreaterThanOrEqualTo(String value) {
            addCriterion("resu_name >=", value, "resuName");
            return (Criteria) this;
        }

        public Criteria andResuNameLessThan(String value) {
            addCriterion("resu_name <", value, "resuName");
            return (Criteria) this;
        }

        public Criteria andResuNameLessThanOrEqualTo(String value) {
            addCriterion("resu_name <=", value, "resuName");
            return (Criteria) this;
        }

        public Criteria andResuNameLike(String value) {
            addCriterion("resu_name like", value, "resuName");
            return (Criteria) this;
        }

        public Criteria andResuNameNotLike(String value) {
            addCriterion("resu_name not like", value, "resuName");
            return (Criteria) this;
        }

        public Criteria andResuNameIn(List<String> values) {
            addCriterion("resu_name in", values, "resuName");
            return (Criteria) this;
        }

        public Criteria andResuNameNotIn(List<String> values) {
            addCriterion("resu_name not in", values, "resuName");
            return (Criteria) this;
        }

        public Criteria andResuNameBetween(String value1, String value2) {
            addCriterion("resu_name between", value1, value2, "resuName");
            return (Criteria) this;
        }

        public Criteria andResuNameNotBetween(String value1, String value2) {
            addCriterion("resu_name not between", value1, value2, "resuName");
            return (Criteria) this;
        }

        public Criteria andResuNumberIsNull() {
            addCriterion("resu_number is null");
            return (Criteria) this;
        }

        public Criteria andResuNumberIsNotNull() {
            addCriterion("resu_number is not null");
            return (Criteria) this;
        }

        public Criteria andResuNumberEqualTo(String value) {
            addCriterion("resu_number =", value, "resuNumber");
            return (Criteria) this;
        }

        public Criteria andResuNumberNotEqualTo(String value) {
            addCriterion("resu_number <>", value, "resuNumber");
            return (Criteria) this;
        }

        public Criteria andResuNumberGreaterThan(String value) {
            addCriterion("resu_number >", value, "resuNumber");
            return (Criteria) this;
        }

        public Criteria andResuNumberGreaterThanOrEqualTo(String value) {
            addCriterion("resu_number >=", value, "resuNumber");
            return (Criteria) this;
        }

        public Criteria andResuNumberLessThan(String value) {
            addCriterion("resu_number <", value, "resuNumber");
            return (Criteria) this;
        }

        public Criteria andResuNumberLessThanOrEqualTo(String value) {
            addCriterion("resu_number <=", value, "resuNumber");
            return (Criteria) this;
        }

        public Criteria andResuNumberLike(String value) {
            addCriterion("resu_number like", value, "resuNumber");
            return (Criteria) this;
        }

        public Criteria andResuNumberNotLike(String value) {
            addCriterion("resu_number not like", value, "resuNumber");
            return (Criteria) this;
        }

        public Criteria andResuNumberIn(List<String> values) {
            addCriterion("resu_number in", values, "resuNumber");
            return (Criteria) this;
        }

        public Criteria andResuNumberNotIn(List<String> values) {
            addCriterion("resu_number not in", values, "resuNumber");
            return (Criteria) this;
        }

        public Criteria andResuNumberBetween(String value1, String value2) {
            addCriterion("resu_number between", value1, value2, "resuNumber");
            return (Criteria) this;
        }

        public Criteria andResuNumberNotBetween(String value1, String value2) {
            addCriterion("resu_number not between", value1, value2, "resuNumber");
            return (Criteria) this;
        }

        public Criteria andResuMajorIsNull() {
            addCriterion("resu_major is null");
            return (Criteria) this;
        }

        public Criteria andResuMajorIsNotNull() {
            addCriterion("resu_major is not null");
            return (Criteria) this;
        }

        public Criteria andResuMajorEqualTo(String value) {
            addCriterion("resu_major =", value, "resuMajor");
            return (Criteria) this;
        }

        public Criteria andResuMajorNotEqualTo(String value) {
            addCriterion("resu_major <>", value, "resuMajor");
            return (Criteria) this;
        }

        public Criteria andResuMajorGreaterThan(String value) {
            addCriterion("resu_major >", value, "resuMajor");
            return (Criteria) this;
        }

        public Criteria andResuMajorGreaterThanOrEqualTo(String value) {
            addCriterion("resu_major >=", value, "resuMajor");
            return (Criteria) this;
        }

        public Criteria andResuMajorLessThan(String value) {
            addCriterion("resu_major <", value, "resuMajor");
            return (Criteria) this;
        }

        public Criteria andResuMajorLessThanOrEqualTo(String value) {
            addCriterion("resu_major <=", value, "resuMajor");
            return (Criteria) this;
        }

        public Criteria andResuMajorLike(String value) {
            addCriterion("resu_major like", value, "resuMajor");
            return (Criteria) this;
        }

        public Criteria andResuMajorNotLike(String value) {
            addCriterion("resu_major not like", value, "resuMajor");
            return (Criteria) this;
        }

        public Criteria andResuMajorIn(List<String> values) {
            addCriterion("resu_major in", values, "resuMajor");
            return (Criteria) this;
        }

        public Criteria andResuMajorNotIn(List<String> values) {
            addCriterion("resu_major not in", values, "resuMajor");
            return (Criteria) this;
        }

        public Criteria andResuMajorBetween(String value1, String value2) {
            addCriterion("resu_major between", value1, value2, "resuMajor");
            return (Criteria) this;
        }

        public Criteria andResuMajorNotBetween(String value1, String value2) {
            addCriterion("resu_major not between", value1, value2, "resuMajor");
            return (Criteria) this;
        }

        public Criteria andResuWechatIsNull() {
            addCriterion("resu_wechat is null");
            return (Criteria) this;
        }

        public Criteria andResuWechatIsNotNull() {
            addCriterion("resu_wechat is not null");
            return (Criteria) this;
        }

        public Criteria andResuWechatEqualTo(String value) {
            addCriterion("resu_wechat =", value, "resuWechat");
            return (Criteria) this;
        }

        public Criteria andResuWechatNotEqualTo(String value) {
            addCriterion("resu_wechat <>", value, "resuWechat");
            return (Criteria) this;
        }

        public Criteria andResuWechatGreaterThan(String value) {
            addCriterion("resu_wechat >", value, "resuWechat");
            return (Criteria) this;
        }

        public Criteria andResuWechatGreaterThanOrEqualTo(String value) {
            addCriterion("resu_wechat >=", value, "resuWechat");
            return (Criteria) this;
        }

        public Criteria andResuWechatLessThan(String value) {
            addCriterion("resu_wechat <", value, "resuWechat");
            return (Criteria) this;
        }

        public Criteria andResuWechatLessThanOrEqualTo(String value) {
            addCriterion("resu_wechat <=", value, "resuWechat");
            return (Criteria) this;
        }

        public Criteria andResuWechatLike(String value) {
            addCriterion("resu_wechat like", value, "resuWechat");
            return (Criteria) this;
        }

        public Criteria andResuWechatNotLike(String value) {
            addCriterion("resu_wechat not like", value, "resuWechat");
            return (Criteria) this;
        }

        public Criteria andResuWechatIn(List<String> values) {
            addCriterion("resu_wechat in", values, "resuWechat");
            return (Criteria) this;
        }

        public Criteria andResuWechatNotIn(List<String> values) {
            addCriterion("resu_wechat not in", values, "resuWechat");
            return (Criteria) this;
        }

        public Criteria andResuWechatBetween(String value1, String value2) {
            addCriterion("resu_wechat between", value1, value2, "resuWechat");
            return (Criteria) this;
        }

        public Criteria andResuWechatNotBetween(String value1, String value2) {
            addCriterion("resu_wechat not between", value1, value2, "resuWechat");
            return (Criteria) this;
        }

        public Criteria andResuDirectIsNull() {
            addCriterion("resu_direct is null");
            return (Criteria) this;
        }

        public Criteria andResuDirectIsNotNull() {
            addCriterion("resu_direct is not null");
            return (Criteria) this;
        }

        public Criteria andResuDirectEqualTo(String value) {
            addCriterion("resu_direct =", value, "resuDirect");
            return (Criteria) this;
        }

        public Criteria andResuDirectNotEqualTo(String value) {
            addCriterion("resu_direct <>", value, "resuDirect");
            return (Criteria) this;
        }

        public Criteria andResuDirectGreaterThan(String value) {
            addCriterion("resu_direct >", value, "resuDirect");
            return (Criteria) this;
        }

        public Criteria andResuDirectGreaterThanOrEqualTo(String value) {
            addCriterion("resu_direct >=", value, "resuDirect");
            return (Criteria) this;
        }

        public Criteria andResuDirectLessThan(String value) {
            addCriterion("resu_direct <", value, "resuDirect");
            return (Criteria) this;
        }

        public Criteria andResuDirectLessThanOrEqualTo(String value) {
            addCriterion("resu_direct <=", value, "resuDirect");
            return (Criteria) this;
        }

        public Criteria andResuDirectLike(String value) {
            addCriterion("resu_direct like", value, "resuDirect");
            return (Criteria) this;
        }

        public Criteria andResuDirectNotLike(String value) {
            addCriterion("resu_direct not like", value, "resuDirect");
            return (Criteria) this;
        }

        public Criteria andResuDirectIn(List<String> values) {
            addCriterion("resu_direct in", values, "resuDirect");
            return (Criteria) this;
        }

        public Criteria andResuDirectNotIn(List<String> values) {
            addCriterion("resu_direct not in", values, "resuDirect");
            return (Criteria) this;
        }

        public Criteria andResuDirectBetween(String value1, String value2) {
            addCriterion("resu_direct between", value1, value2, "resuDirect");
            return (Criteria) this;
        }

        public Criteria andResuDirectNotBetween(String value1, String value2) {
            addCriterion("resu_direct not between", value1, value2, "resuDirect");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationIsNull() {
            addCriterion("resu_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationIsNotNull() {
            addCriterion("resu_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationEqualTo(String value) {
            addCriterion("resu_evaluation =", value, "resuEvaluation");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationNotEqualTo(String value) {
            addCriterion("resu_evaluation <>", value, "resuEvaluation");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationGreaterThan(String value) {
            addCriterion("resu_evaluation >", value, "resuEvaluation");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationGreaterThanOrEqualTo(String value) {
            addCriterion("resu_evaluation >=", value, "resuEvaluation");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationLessThan(String value) {
            addCriterion("resu_evaluation <", value, "resuEvaluation");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationLessThanOrEqualTo(String value) {
            addCriterion("resu_evaluation <=", value, "resuEvaluation");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationLike(String value) {
            addCriterion("resu_evaluation like", value, "resuEvaluation");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationNotLike(String value) {
            addCriterion("resu_evaluation not like", value, "resuEvaluation");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationIn(List<String> values) {
            addCriterion("resu_evaluation in", values, "resuEvaluation");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationNotIn(List<String> values) {
            addCriterion("resu_evaluation not in", values, "resuEvaluation");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationBetween(String value1, String value2) {
            addCriterion("resu_evaluation between", value1, value2, "resuEvaluation");
            return (Criteria) this;
        }

        public Criteria andResuEvaluationNotBetween(String value1, String value2) {
            addCriterion("resu_evaluation not between", value1, value2, "resuEvaluation");
            return (Criteria) this;
        }

        public Criteria andResuSkillsIsNull() {
            addCriterion("resu_skills is null");
            return (Criteria) this;
        }

        public Criteria andResuSkillsIsNotNull() {
            addCriterion("resu_skills is not null");
            return (Criteria) this;
        }

        public Criteria andResuSkillsEqualTo(String value) {
            addCriterion("resu_skills =", value, "resuSkills");
            return (Criteria) this;
        }

        public Criteria andResuSkillsNotEqualTo(String value) {
            addCriterion("resu_skills <>", value, "resuSkills");
            return (Criteria) this;
        }

        public Criteria andResuSkillsGreaterThan(String value) {
            addCriterion("resu_skills >", value, "resuSkills");
            return (Criteria) this;
        }

        public Criteria andResuSkillsGreaterThanOrEqualTo(String value) {
            addCriterion("resu_skills >=", value, "resuSkills");
            return (Criteria) this;
        }

        public Criteria andResuSkillsLessThan(String value) {
            addCriterion("resu_skills <", value, "resuSkills");
            return (Criteria) this;
        }

        public Criteria andResuSkillsLessThanOrEqualTo(String value) {
            addCriterion("resu_skills <=", value, "resuSkills");
            return (Criteria) this;
        }

        public Criteria andResuSkillsLike(String value) {
            addCriterion("resu_skills like", value, "resuSkills");
            return (Criteria) this;
        }

        public Criteria andResuSkillsNotLike(String value) {
            addCriterion("resu_skills not like", value, "resuSkills");
            return (Criteria) this;
        }

        public Criteria andResuSkillsIn(List<String> values) {
            addCriterion("resu_skills in", values, "resuSkills");
            return (Criteria) this;
        }

        public Criteria andResuSkillsNotIn(List<String> values) {
            addCriterion("resu_skills not in", values, "resuSkills");
            return (Criteria) this;
        }

        public Criteria andResuSkillsBetween(String value1, String value2) {
            addCriterion("resu_skills between", value1, value2, "resuSkills");
            return (Criteria) this;
        }

        public Criteria andResuSkillsNotBetween(String value1, String value2) {
            addCriterion("resu_skills not between", value1, value2, "resuSkills");
            return (Criteria) this;
        }

        public Criteria andResuExpIsNull() {
            addCriterion("resu_exp is null");
            return (Criteria) this;
        }

        public Criteria andResuExpIsNotNull() {
            addCriterion("resu_exp is not null");
            return (Criteria) this;
        }

        public Criteria andResuExpEqualTo(String value) {
            addCriterion("resu_exp =", value, "resuExp");
            return (Criteria) this;
        }

        public Criteria andResuExpNotEqualTo(String value) {
            addCriterion("resu_exp <>", value, "resuExp");
            return (Criteria) this;
        }

        public Criteria andResuExpGreaterThan(String value) {
            addCriterion("resu_exp >", value, "resuExp");
            return (Criteria) this;
        }

        public Criteria andResuExpGreaterThanOrEqualTo(String value) {
            addCriterion("resu_exp >=", value, "resuExp");
            return (Criteria) this;
        }

        public Criteria andResuExpLessThan(String value) {
            addCriterion("resu_exp <", value, "resuExp");
            return (Criteria) this;
        }

        public Criteria andResuExpLessThanOrEqualTo(String value) {
            addCriterion("resu_exp <=", value, "resuExp");
            return (Criteria) this;
        }

        public Criteria andResuExpLike(String value) {
            addCriterion("resu_exp like", value, "resuExp");
            return (Criteria) this;
        }

        public Criteria andResuExpNotLike(String value) {
            addCriterion("resu_exp not like", value, "resuExp");
            return (Criteria) this;
        }

        public Criteria andResuExpIn(List<String> values) {
            addCriterion("resu_exp in", values, "resuExp");
            return (Criteria) this;
        }

        public Criteria andResuExpNotIn(List<String> values) {
            addCriterion("resu_exp not in", values, "resuExp");
            return (Criteria) this;
        }

        public Criteria andResuExpBetween(String value1, String value2) {
            addCriterion("resu_exp between", value1, value2, "resuExp");
            return (Criteria) this;
        }

        public Criteria andResuExpNotBetween(String value1, String value2) {
            addCriterion("resu_exp not between", value1, value2, "resuExp");
            return (Criteria) this;
        }

        public Criteria andResuExpectIsNull() {
            addCriterion("resu_expect is null");
            return (Criteria) this;
        }

        public Criteria andResuExpectIsNotNull() {
            addCriterion("resu_expect is not null");
            return (Criteria) this;
        }

        public Criteria andResuExpectEqualTo(String value) {
            addCriterion("resu_expect =", value, "resuExpect");
            return (Criteria) this;
        }

        public Criteria andResuExpectNotEqualTo(String value) {
            addCriterion("resu_expect <>", value, "resuExpect");
            return (Criteria) this;
        }

        public Criteria andResuExpectGreaterThan(String value) {
            addCriterion("resu_expect >", value, "resuExpect");
            return (Criteria) this;
        }

        public Criteria andResuExpectGreaterThanOrEqualTo(String value) {
            addCriterion("resu_expect >=", value, "resuExpect");
            return (Criteria) this;
        }

        public Criteria andResuExpectLessThan(String value) {
            addCriterion("resu_expect <", value, "resuExpect");
            return (Criteria) this;
        }

        public Criteria andResuExpectLessThanOrEqualTo(String value) {
            addCriterion("resu_expect <=", value, "resuExpect");
            return (Criteria) this;
        }

        public Criteria andResuExpectLike(String value) {
            addCriterion("resu_expect like", value, "resuExpect");
            return (Criteria) this;
        }

        public Criteria andResuExpectNotLike(String value) {
            addCriterion("resu_expect not like", value, "resuExpect");
            return (Criteria) this;
        }

        public Criteria andResuExpectIn(List<String> values) {
            addCriterion("resu_expect in", values, "resuExpect");
            return (Criteria) this;
        }

        public Criteria andResuExpectNotIn(List<String> values) {
            addCriterion("resu_expect not in", values, "resuExpect");
            return (Criteria) this;
        }

        public Criteria andResuExpectBetween(String value1, String value2) {
            addCriterion("resu_expect between", value1, value2, "resuExpect");
            return (Criteria) this;
        }

        public Criteria andResuExpectNotBetween(String value1, String value2) {
            addCriterion("resu_expect not between", value1, value2, "resuExpect");
            return (Criteria) this;
        }

        public Criteria andResuOtherIsNull() {
            addCriterion("resu_other is null");
            return (Criteria) this;
        }

        public Criteria andResuOtherIsNotNull() {
            addCriterion("resu_other is not null");
            return (Criteria) this;
        }

        public Criteria andResuOtherEqualTo(String value) {
            addCriterion("resu_other =", value, "resuOther");
            return (Criteria) this;
        }

        public Criteria andResuOtherNotEqualTo(String value) {
            addCriterion("resu_other <>", value, "resuOther");
            return (Criteria) this;
        }

        public Criteria andResuOtherGreaterThan(String value) {
            addCriterion("resu_other >", value, "resuOther");
            return (Criteria) this;
        }

        public Criteria andResuOtherGreaterThanOrEqualTo(String value) {
            addCriterion("resu_other >=", value, "resuOther");
            return (Criteria) this;
        }

        public Criteria andResuOtherLessThan(String value) {
            addCriterion("resu_other <", value, "resuOther");
            return (Criteria) this;
        }

        public Criteria andResuOtherLessThanOrEqualTo(String value) {
            addCriterion("resu_other <=", value, "resuOther");
            return (Criteria) this;
        }

        public Criteria andResuOtherLike(String value) {
            addCriterion("resu_other like", value, "resuOther");
            return (Criteria) this;
        }

        public Criteria andResuOtherNotLike(String value) {
            addCriterion("resu_other not like", value, "resuOther");
            return (Criteria) this;
        }

        public Criteria andResuOtherIn(List<String> values) {
            addCriterion("resu_other in", values, "resuOther");
            return (Criteria) this;
        }

        public Criteria andResuOtherNotIn(List<String> values) {
            addCriterion("resu_other not in", values, "resuOther");
            return (Criteria) this;
        }

        public Criteria andResuOtherBetween(String value1, String value2) {
            addCriterion("resu_other between", value1, value2, "resuOther");
            return (Criteria) this;
        }

        public Criteria andResuOtherNotBetween(String value1, String value2) {
            addCriterion("resu_other not between", value1, value2, "resuOther");
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