package com.turing.turing.entity;

import java.util.ArrayList;
import java.util.List;

public class CollectResumeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectResumeExample() {
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

        public Criteria andColResuIdIsNull() {
            addCriterion("col_resu_id is null");
            return (Criteria) this;
        }

        public Criteria andColResuIdIsNotNull() {
            addCriterion("col_resu_id is not null");
            return (Criteria) this;
        }

        public Criteria andColResuIdEqualTo(Integer value) {
            addCriterion("col_resu_id =", value, "colResuId");
            return (Criteria) this;
        }

        public Criteria andColResuIdNotEqualTo(Integer value) {
            addCriterion("col_resu_id <>", value, "colResuId");
            return (Criteria) this;
        }

        public Criteria andColResuIdGreaterThan(Integer value) {
            addCriterion("col_resu_id >", value, "colResuId");
            return (Criteria) this;
        }

        public Criteria andColResuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("col_resu_id >=", value, "colResuId");
            return (Criteria) this;
        }

        public Criteria andColResuIdLessThan(Integer value) {
            addCriterion("col_resu_id <", value, "colResuId");
            return (Criteria) this;
        }

        public Criteria andColResuIdLessThanOrEqualTo(Integer value) {
            addCriterion("col_resu_id <=", value, "colResuId");
            return (Criteria) this;
        }

        public Criteria andColResuIdIn(List<Integer> values) {
            addCriterion("col_resu_id in", values, "colResuId");
            return (Criteria) this;
        }

        public Criteria andColResuIdNotIn(List<Integer> values) {
            addCriterion("col_resu_id not in", values, "colResuId");
            return (Criteria) this;
        }

        public Criteria andColResuIdBetween(Integer value1, Integer value2) {
            addCriterion("col_resu_id between", value1, value2, "colResuId");
            return (Criteria) this;
        }

        public Criteria andColResuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("col_resu_id not between", value1, value2, "colResuId");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidIsNull() {
            addCriterion("col_resu_studentId is null");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidIsNotNull() {
            addCriterion("col_resu_studentId is not null");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidEqualTo(String value) {
            addCriterion("col_resu_studentId =", value, "colResuStudentid");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidNotEqualTo(String value) {
            addCriterion("col_resu_studentId <>", value, "colResuStudentid");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidGreaterThan(String value) {
            addCriterion("col_resu_studentId >", value, "colResuStudentid");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidGreaterThanOrEqualTo(String value) {
            addCriterion("col_resu_studentId >=", value, "colResuStudentid");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidLessThan(String value) {
            addCriterion("col_resu_studentId <", value, "colResuStudentid");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidLessThanOrEqualTo(String value) {
            addCriterion("col_resu_studentId <=", value, "colResuStudentid");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidLike(String value) {
            addCriterion("col_resu_studentId like", value, "colResuStudentid");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidNotLike(String value) {
            addCriterion("col_resu_studentId not like", value, "colResuStudentid");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidIn(List<String> values) {
            addCriterion("col_resu_studentId in", values, "colResuStudentid");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidNotIn(List<String> values) {
            addCriterion("col_resu_studentId not in", values, "colResuStudentid");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidBetween(String value1, String value2) {
            addCriterion("col_resu_studentId between", value1, value2, "colResuStudentid");
            return (Criteria) this;
        }

        public Criteria andColResuStudentidNotBetween(String value1, String value2) {
            addCriterion("col_resu_studentId not between", value1, value2, "colResuStudentid");
            return (Criteria) this;
        }

        public Criteria andColResuNameIsNull() {
            addCriterion("col_resu_name is null");
            return (Criteria) this;
        }

        public Criteria andColResuNameIsNotNull() {
            addCriterion("col_resu_name is not null");
            return (Criteria) this;
        }

        public Criteria andColResuNameEqualTo(String value) {
            addCriterion("col_resu_name =", value, "colResuName");
            return (Criteria) this;
        }

        public Criteria andColResuNameNotEqualTo(String value) {
            addCriterion("col_resu_name <>", value, "colResuName");
            return (Criteria) this;
        }

        public Criteria andColResuNameGreaterThan(String value) {
            addCriterion("col_resu_name >", value, "colResuName");
            return (Criteria) this;
        }

        public Criteria andColResuNameGreaterThanOrEqualTo(String value) {
            addCriterion("col_resu_name >=", value, "colResuName");
            return (Criteria) this;
        }

        public Criteria andColResuNameLessThan(String value) {
            addCriterion("col_resu_name <", value, "colResuName");
            return (Criteria) this;
        }

        public Criteria andColResuNameLessThanOrEqualTo(String value) {
            addCriterion("col_resu_name <=", value, "colResuName");
            return (Criteria) this;
        }

        public Criteria andColResuNameLike(String value) {
            addCriterion("col_resu_name like", value, "colResuName");
            return (Criteria) this;
        }

        public Criteria andColResuNameNotLike(String value) {
            addCriterion("col_resu_name not like", value, "colResuName");
            return (Criteria) this;
        }

        public Criteria andColResuNameIn(List<String> values) {
            addCriterion("col_resu_name in", values, "colResuName");
            return (Criteria) this;
        }

        public Criteria andColResuNameNotIn(List<String> values) {
            addCriterion("col_resu_name not in", values, "colResuName");
            return (Criteria) this;
        }

        public Criteria andColResuNameBetween(String value1, String value2) {
            addCriterion("col_resu_name between", value1, value2, "colResuName");
            return (Criteria) this;
        }

        public Criteria andColResuNameNotBetween(String value1, String value2) {
            addCriterion("col_resu_name not between", value1, value2, "colResuName");
            return (Criteria) this;
        }

        public Criteria andColResuNumberIsNull() {
            addCriterion("col_resu_number is null");
            return (Criteria) this;
        }

        public Criteria andColResuNumberIsNotNull() {
            addCriterion("col_resu_number is not null");
            return (Criteria) this;
        }

        public Criteria andColResuNumberEqualTo(String value) {
            addCriterion("col_resu_number =", value, "colResuNumber");
            return (Criteria) this;
        }

        public Criteria andColResuNumberNotEqualTo(String value) {
            addCriterion("col_resu_number <>", value, "colResuNumber");
            return (Criteria) this;
        }

        public Criteria andColResuNumberGreaterThan(String value) {
            addCriterion("col_resu_number >", value, "colResuNumber");
            return (Criteria) this;
        }

        public Criteria andColResuNumberGreaterThanOrEqualTo(String value) {
            addCriterion("col_resu_number >=", value, "colResuNumber");
            return (Criteria) this;
        }

        public Criteria andColResuNumberLessThan(String value) {
            addCriterion("col_resu_number <", value, "colResuNumber");
            return (Criteria) this;
        }

        public Criteria andColResuNumberLessThanOrEqualTo(String value) {
            addCriterion("col_resu_number <=", value, "colResuNumber");
            return (Criteria) this;
        }

        public Criteria andColResuNumberLike(String value) {
            addCriterion("col_resu_number like", value, "colResuNumber");
            return (Criteria) this;
        }

        public Criteria andColResuNumberNotLike(String value) {
            addCriterion("col_resu_number not like", value, "colResuNumber");
            return (Criteria) this;
        }

        public Criteria andColResuNumberIn(List<String> values) {
            addCriterion("col_resu_number in", values, "colResuNumber");
            return (Criteria) this;
        }

        public Criteria andColResuNumberNotIn(List<String> values) {
            addCriterion("col_resu_number not in", values, "colResuNumber");
            return (Criteria) this;
        }

        public Criteria andColResuNumberBetween(String value1, String value2) {
            addCriterion("col_resu_number between", value1, value2, "colResuNumber");
            return (Criteria) this;
        }

        public Criteria andColResuNumberNotBetween(String value1, String value2) {
            addCriterion("col_resu_number not between", value1, value2, "colResuNumber");
            return (Criteria) this;
        }

        public Criteria andColResuMajorIsNull() {
            addCriterion("col_resu_major is null");
            return (Criteria) this;
        }

        public Criteria andColResuMajorIsNotNull() {
            addCriterion("col_resu_major is not null");
            return (Criteria) this;
        }

        public Criteria andColResuMajorEqualTo(String value) {
            addCriterion("col_resu_major =", value, "colResuMajor");
            return (Criteria) this;
        }

        public Criteria andColResuMajorNotEqualTo(String value) {
            addCriterion("col_resu_major <>", value, "colResuMajor");
            return (Criteria) this;
        }

        public Criteria andColResuMajorGreaterThan(String value) {
            addCriterion("col_resu_major >", value, "colResuMajor");
            return (Criteria) this;
        }

        public Criteria andColResuMajorGreaterThanOrEqualTo(String value) {
            addCriterion("col_resu_major >=", value, "colResuMajor");
            return (Criteria) this;
        }

        public Criteria andColResuMajorLessThan(String value) {
            addCriterion("col_resu_major <", value, "colResuMajor");
            return (Criteria) this;
        }

        public Criteria andColResuMajorLessThanOrEqualTo(String value) {
            addCriterion("col_resu_major <=", value, "colResuMajor");
            return (Criteria) this;
        }

        public Criteria andColResuMajorLike(String value) {
            addCriterion("col_resu_major like", value, "colResuMajor");
            return (Criteria) this;
        }

        public Criteria andColResuMajorNotLike(String value) {
            addCriterion("col_resu_major not like", value, "colResuMajor");
            return (Criteria) this;
        }

        public Criteria andColResuMajorIn(List<String> values) {
            addCriterion("col_resu_major in", values, "colResuMajor");
            return (Criteria) this;
        }

        public Criteria andColResuMajorNotIn(List<String> values) {
            addCriterion("col_resu_major not in", values, "colResuMajor");
            return (Criteria) this;
        }

        public Criteria andColResuMajorBetween(String value1, String value2) {
            addCriterion("col_resu_major between", value1, value2, "colResuMajor");
            return (Criteria) this;
        }

        public Criteria andColResuMajorNotBetween(String value1, String value2) {
            addCriterion("col_resu_major not between", value1, value2, "colResuMajor");
            return (Criteria) this;
        }

        public Criteria andColResuWechatIsNull() {
            addCriterion("col_resu_wechat is null");
            return (Criteria) this;
        }

        public Criteria andColResuWechatIsNotNull() {
            addCriterion("col_resu_wechat is not null");
            return (Criteria) this;
        }

        public Criteria andColResuWechatEqualTo(String value) {
            addCriterion("col_resu_wechat =", value, "colResuWechat");
            return (Criteria) this;
        }

        public Criteria andColResuWechatNotEqualTo(String value) {
            addCriterion("col_resu_wechat <>", value, "colResuWechat");
            return (Criteria) this;
        }

        public Criteria andColResuWechatGreaterThan(String value) {
            addCriterion("col_resu_wechat >", value, "colResuWechat");
            return (Criteria) this;
        }

        public Criteria andColResuWechatGreaterThanOrEqualTo(String value) {
            addCriterion("col_resu_wechat >=", value, "colResuWechat");
            return (Criteria) this;
        }

        public Criteria andColResuWechatLessThan(String value) {
            addCriterion("col_resu_wechat <", value, "colResuWechat");
            return (Criteria) this;
        }

        public Criteria andColResuWechatLessThanOrEqualTo(String value) {
            addCriterion("col_resu_wechat <=", value, "colResuWechat");
            return (Criteria) this;
        }

        public Criteria andColResuWechatLike(String value) {
            addCriterion("col_resu_wechat like", value, "colResuWechat");
            return (Criteria) this;
        }

        public Criteria andColResuWechatNotLike(String value) {
            addCriterion("col_resu_wechat not like", value, "colResuWechat");
            return (Criteria) this;
        }

        public Criteria andColResuWechatIn(List<String> values) {
            addCriterion("col_resu_wechat in", values, "colResuWechat");
            return (Criteria) this;
        }

        public Criteria andColResuWechatNotIn(List<String> values) {
            addCriterion("col_resu_wechat not in", values, "colResuWechat");
            return (Criteria) this;
        }

        public Criteria andColResuWechatBetween(String value1, String value2) {
            addCriterion("col_resu_wechat between", value1, value2, "colResuWechat");
            return (Criteria) this;
        }

        public Criteria andColResuWechatNotBetween(String value1, String value2) {
            addCriterion("col_resu_wechat not between", value1, value2, "colResuWechat");
            return (Criteria) this;
        }

        public Criteria andColResuDirectIsNull() {
            addCriterion("col_resu_direct is null");
            return (Criteria) this;
        }

        public Criteria andColResuDirectIsNotNull() {
            addCriterion("col_resu_direct is not null");
            return (Criteria) this;
        }

        public Criteria andColResuDirectEqualTo(String value) {
            addCriterion("col_resu_direct =", value, "colResuDirect");
            return (Criteria) this;
        }

        public Criteria andColResuDirectNotEqualTo(String value) {
            addCriterion("col_resu_direct <>", value, "colResuDirect");
            return (Criteria) this;
        }

        public Criteria andColResuDirectGreaterThan(String value) {
            addCriterion("col_resu_direct >", value, "colResuDirect");
            return (Criteria) this;
        }

        public Criteria andColResuDirectGreaterThanOrEqualTo(String value) {
            addCriterion("col_resu_direct >=", value, "colResuDirect");
            return (Criteria) this;
        }

        public Criteria andColResuDirectLessThan(String value) {
            addCriterion("col_resu_direct <", value, "colResuDirect");
            return (Criteria) this;
        }

        public Criteria andColResuDirectLessThanOrEqualTo(String value) {
            addCriterion("col_resu_direct <=", value, "colResuDirect");
            return (Criteria) this;
        }

        public Criteria andColResuDirectLike(String value) {
            addCriterion("col_resu_direct like", value, "colResuDirect");
            return (Criteria) this;
        }

        public Criteria andColResuDirectNotLike(String value) {
            addCriterion("col_resu_direct not like", value, "colResuDirect");
            return (Criteria) this;
        }

        public Criteria andColResuDirectIn(List<String> values) {
            addCriterion("col_resu_direct in", values, "colResuDirect");
            return (Criteria) this;
        }

        public Criteria andColResuDirectNotIn(List<String> values) {
            addCriterion("col_resu_direct not in", values, "colResuDirect");
            return (Criteria) this;
        }

        public Criteria andColResuDirectBetween(String value1, String value2) {
            addCriterion("col_resu_direct between", value1, value2, "colResuDirect");
            return (Criteria) this;
        }

        public Criteria andColResuDirectNotBetween(String value1, String value2) {
            addCriterion("col_resu_direct not between", value1, value2, "colResuDirect");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationIsNull() {
            addCriterion("col_resu_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationIsNotNull() {
            addCriterion("col_resu_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationEqualTo(String value) {
            addCriterion("col_resu_evaluation =", value, "colResuEvaluation");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationNotEqualTo(String value) {
            addCriterion("col_resu_evaluation <>", value, "colResuEvaluation");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationGreaterThan(String value) {
            addCriterion("col_resu_evaluation >", value, "colResuEvaluation");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationGreaterThanOrEqualTo(String value) {
            addCriterion("col_resu_evaluation >=", value, "colResuEvaluation");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationLessThan(String value) {
            addCriterion("col_resu_evaluation <", value, "colResuEvaluation");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationLessThanOrEqualTo(String value) {
            addCriterion("col_resu_evaluation <=", value, "colResuEvaluation");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationLike(String value) {
            addCriterion("col_resu_evaluation like", value, "colResuEvaluation");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationNotLike(String value) {
            addCriterion("col_resu_evaluation not like", value, "colResuEvaluation");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationIn(List<String> values) {
            addCriterion("col_resu_evaluation in", values, "colResuEvaluation");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationNotIn(List<String> values) {
            addCriterion("col_resu_evaluation not in", values, "colResuEvaluation");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationBetween(String value1, String value2) {
            addCriterion("col_resu_evaluation between", value1, value2, "colResuEvaluation");
            return (Criteria) this;
        }

        public Criteria andColResuEvaluationNotBetween(String value1, String value2) {
            addCriterion("col_resu_evaluation not between", value1, value2, "colResuEvaluation");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsIsNull() {
            addCriterion("col_resu_skills is null");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsIsNotNull() {
            addCriterion("col_resu_skills is not null");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsEqualTo(String value) {
            addCriterion("col_resu_skills =", value, "colResuSkills");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsNotEqualTo(String value) {
            addCriterion("col_resu_skills <>", value, "colResuSkills");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsGreaterThan(String value) {
            addCriterion("col_resu_skills >", value, "colResuSkills");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsGreaterThanOrEqualTo(String value) {
            addCriterion("col_resu_skills >=", value, "colResuSkills");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsLessThan(String value) {
            addCriterion("col_resu_skills <", value, "colResuSkills");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsLessThanOrEqualTo(String value) {
            addCriterion("col_resu_skills <=", value, "colResuSkills");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsLike(String value) {
            addCriterion("col_resu_skills like", value, "colResuSkills");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsNotLike(String value) {
            addCriterion("col_resu_skills not like", value, "colResuSkills");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsIn(List<String> values) {
            addCriterion("col_resu_skills in", values, "colResuSkills");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsNotIn(List<String> values) {
            addCriterion("col_resu_skills not in", values, "colResuSkills");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsBetween(String value1, String value2) {
            addCriterion("col_resu_skills between", value1, value2, "colResuSkills");
            return (Criteria) this;
        }

        public Criteria andColResuSkillsNotBetween(String value1, String value2) {
            addCriterion("col_resu_skills not between", value1, value2, "colResuSkills");
            return (Criteria) this;
        }

        public Criteria andColResuExpIsNull() {
            addCriterion("col_resu_exp is null");
            return (Criteria) this;
        }

        public Criteria andColResuExpIsNotNull() {
            addCriterion("col_resu_exp is not null");
            return (Criteria) this;
        }

        public Criteria andColResuExpEqualTo(String value) {
            addCriterion("col_resu_exp =", value, "colResuExp");
            return (Criteria) this;
        }

        public Criteria andColResuExpNotEqualTo(String value) {
            addCriterion("col_resu_exp <>", value, "colResuExp");
            return (Criteria) this;
        }

        public Criteria andColResuExpGreaterThan(String value) {
            addCriterion("col_resu_exp >", value, "colResuExp");
            return (Criteria) this;
        }

        public Criteria andColResuExpGreaterThanOrEqualTo(String value) {
            addCriterion("col_resu_exp >=", value, "colResuExp");
            return (Criteria) this;
        }

        public Criteria andColResuExpLessThan(String value) {
            addCriterion("col_resu_exp <", value, "colResuExp");
            return (Criteria) this;
        }

        public Criteria andColResuExpLessThanOrEqualTo(String value) {
            addCriterion("col_resu_exp <=", value, "colResuExp");
            return (Criteria) this;
        }

        public Criteria andColResuExpLike(String value) {
            addCriterion("col_resu_exp like", value, "colResuExp");
            return (Criteria) this;
        }

        public Criteria andColResuExpNotLike(String value) {
            addCriterion("col_resu_exp not like", value, "colResuExp");
            return (Criteria) this;
        }

        public Criteria andColResuExpIn(List<String> values) {
            addCriterion("col_resu_exp in", values, "colResuExp");
            return (Criteria) this;
        }

        public Criteria andColResuExpNotIn(List<String> values) {
            addCriterion("col_resu_exp not in", values, "colResuExp");
            return (Criteria) this;
        }

        public Criteria andColResuExpBetween(String value1, String value2) {
            addCriterion("col_resu_exp between", value1, value2, "colResuExp");
            return (Criteria) this;
        }

        public Criteria andColResuExpNotBetween(String value1, String value2) {
            addCriterion("col_resu_exp not between", value1, value2, "colResuExp");
            return (Criteria) this;
        }

        public Criteria andColResuExpectIsNull() {
            addCriterion("col_resu_expect is null");
            return (Criteria) this;
        }

        public Criteria andColResuExpectIsNotNull() {
            addCriterion("col_resu_expect is not null");
            return (Criteria) this;
        }

        public Criteria andColResuExpectEqualTo(String value) {
            addCriterion("col_resu_expect =", value, "colResuExpect");
            return (Criteria) this;
        }

        public Criteria andColResuExpectNotEqualTo(String value) {
            addCriterion("col_resu_expect <>", value, "colResuExpect");
            return (Criteria) this;
        }

        public Criteria andColResuExpectGreaterThan(String value) {
            addCriterion("col_resu_expect >", value, "colResuExpect");
            return (Criteria) this;
        }

        public Criteria andColResuExpectGreaterThanOrEqualTo(String value) {
            addCriterion("col_resu_expect >=", value, "colResuExpect");
            return (Criteria) this;
        }

        public Criteria andColResuExpectLessThan(String value) {
            addCriterion("col_resu_expect <", value, "colResuExpect");
            return (Criteria) this;
        }

        public Criteria andColResuExpectLessThanOrEqualTo(String value) {
            addCriterion("col_resu_expect <=", value, "colResuExpect");
            return (Criteria) this;
        }

        public Criteria andColResuExpectLike(String value) {
            addCriterion("col_resu_expect like", value, "colResuExpect");
            return (Criteria) this;
        }

        public Criteria andColResuExpectNotLike(String value) {
            addCriterion("col_resu_expect not like", value, "colResuExpect");
            return (Criteria) this;
        }

        public Criteria andColResuExpectIn(List<String> values) {
            addCriterion("col_resu_expect in", values, "colResuExpect");
            return (Criteria) this;
        }

        public Criteria andColResuExpectNotIn(List<String> values) {
            addCriterion("col_resu_expect not in", values, "colResuExpect");
            return (Criteria) this;
        }

        public Criteria andColResuExpectBetween(String value1, String value2) {
            addCriterion("col_resu_expect between", value1, value2, "colResuExpect");
            return (Criteria) this;
        }

        public Criteria andColResuExpectNotBetween(String value1, String value2) {
            addCriterion("col_resu_expect not between", value1, value2, "colResuExpect");
            return (Criteria) this;
        }

        public Criteria andColResuOtherIsNull() {
            addCriterion("col_resu_other is null");
            return (Criteria) this;
        }

        public Criteria andColResuOtherIsNotNull() {
            addCriterion("col_resu_other is not null");
            return (Criteria) this;
        }

        public Criteria andColResuOtherEqualTo(String value) {
            addCriterion("col_resu_other =", value, "colResuOther");
            return (Criteria) this;
        }

        public Criteria andColResuOtherNotEqualTo(String value) {
            addCriterion("col_resu_other <>", value, "colResuOther");
            return (Criteria) this;
        }

        public Criteria andColResuOtherGreaterThan(String value) {
            addCriterion("col_resu_other >", value, "colResuOther");
            return (Criteria) this;
        }

        public Criteria andColResuOtherGreaterThanOrEqualTo(String value) {
            addCriterion("col_resu_other >=", value, "colResuOther");
            return (Criteria) this;
        }

        public Criteria andColResuOtherLessThan(String value) {
            addCriterion("col_resu_other <", value, "colResuOther");
            return (Criteria) this;
        }

        public Criteria andColResuOtherLessThanOrEqualTo(String value) {
            addCriterion("col_resu_other <=", value, "colResuOther");
            return (Criteria) this;
        }

        public Criteria andColResuOtherLike(String value) {
            addCriterion("col_resu_other like", value, "colResuOther");
            return (Criteria) this;
        }

        public Criteria andColResuOtherNotLike(String value) {
            addCriterion("col_resu_other not like", value, "colResuOther");
            return (Criteria) this;
        }

        public Criteria andColResuOtherIn(List<String> values) {
            addCriterion("col_resu_other in", values, "colResuOther");
            return (Criteria) this;
        }

        public Criteria andColResuOtherNotIn(List<String> values) {
            addCriterion("col_resu_other not in", values, "colResuOther");
            return (Criteria) this;
        }

        public Criteria andColResuOtherBetween(String value1, String value2) {
            addCriterion("col_resu_other between", value1, value2, "colResuOther");
            return (Criteria) this;
        }

        public Criteria andColResuOtherNotBetween(String value1, String value2) {
            addCriterion("col_resu_other not between", value1, value2, "colResuOther");
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