package com.fanren.wx.app.pojo;

import java.util.ArrayList;
import java.util.List;

public class MajorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MajorExample() {
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

        public Criteria andMajorIdIsNull() {
            addCriterion("major_ID is null");
            return (Criteria) this;
        }

        public Criteria andMajorIdIsNotNull() {
            addCriterion("major_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMajorIdEqualTo(String value) {
            addCriterion("major_ID =", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotEqualTo(String value) {
            addCriterion("major_ID <>", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdGreaterThan(String value) {
            addCriterion("major_ID >", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdGreaterThanOrEqualTo(String value) {
            addCriterion("major_ID >=", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdLessThan(String value) {
            addCriterion("major_ID <", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdLessThanOrEqualTo(String value) {
            addCriterion("major_ID <=", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdLike(String value) {
            addCriterion("major_ID like", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotLike(String value) {
            addCriterion("major_ID not like", value, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdIn(List<String> values) {
            addCriterion("major_ID in", values, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotIn(List<String> values) {
            addCriterion("major_ID not in", values, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdBetween(String value1, String value2) {
            addCriterion("major_ID between", value1, value2, "majorId");
            return (Criteria) this;
        }

        public Criteria andMajorIdNotBetween(String value1, String value2) {
            addCriterion("major_ID not between", value1, value2, "majorId");
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

        public Criteria andClassNumberIsNull() {
            addCriterion("class_number is null");
            return (Criteria) this;
        }

        public Criteria andClassNumberIsNotNull() {
            addCriterion("class_number is not null");
            return (Criteria) this;
        }

        public Criteria andClassNumberEqualTo(String value) {
            addCriterion("class_number =", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotEqualTo(String value) {
            addCriterion("class_number <>", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberGreaterThan(String value) {
            addCriterion("class_number >", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberGreaterThanOrEqualTo(String value) {
            addCriterion("class_number >=", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberLessThan(String value) {
            addCriterion("class_number <", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberLessThanOrEqualTo(String value) {
            addCriterion("class_number <=", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberLike(String value) {
            addCriterion("class_number like", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotLike(String value) {
            addCriterion("class_number not like", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberIn(List<String> values) {
            addCriterion("class_number in", values, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotIn(List<String> values) {
            addCriterion("class_number not in", values, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberBetween(String value1, String value2) {
            addCriterion("class_number between", value1, value2, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotBetween(String value1, String value2) {
            addCriterion("class_number not between", value1, value2, "classNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberIsNull() {
            addCriterion("teacher_number is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberIsNotNull() {
            addCriterion("teacher_number is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberEqualTo(String value) {
            addCriterion("teacher_number =", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberNotEqualTo(String value) {
            addCriterion("teacher_number <>", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberGreaterThan(String value) {
            addCriterion("teacher_number >", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_number >=", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberLessThan(String value) {
            addCriterion("teacher_number <", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberLessThanOrEqualTo(String value) {
            addCriterion("teacher_number <=", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberLike(String value) {
            addCriterion("teacher_number like", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberNotLike(String value) {
            addCriterion("teacher_number not like", value, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberIn(List<String> values) {
            addCriterion("teacher_number in", values, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberNotIn(List<String> values) {
            addCriterion("teacher_number not in", values, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberBetween(String value1, String value2) {
            addCriterion("teacher_number between", value1, value2, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andTeacherNumberNotBetween(String value1, String value2) {
            addCriterion("teacher_number not between", value1, value2, "teacherNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberIsNull() {
            addCriterion("student_number is null");
            return (Criteria) this;
        }

        public Criteria andStudentNumberIsNotNull() {
            addCriterion("student_number is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNumberEqualTo(String value) {
            addCriterion("student_number =", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotEqualTo(String value) {
            addCriterion("student_number <>", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberGreaterThan(String value) {
            addCriterion("student_number >", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberGreaterThanOrEqualTo(String value) {
            addCriterion("student_number >=", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberLessThan(String value) {
            addCriterion("student_number <", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberLessThanOrEqualTo(String value) {
            addCriterion("student_number <=", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberLike(String value) {
            addCriterion("student_number like", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotLike(String value) {
            addCriterion("student_number not like", value, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberIn(List<String> values) {
            addCriterion("student_number in", values, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotIn(List<String> values) {
            addCriterion("student_number not in", values, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberBetween(String value1, String value2) {
            addCriterion("student_number between", value1, value2, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andStudentNumberNotBetween(String value1, String value2) {
            addCriterion("student_number not between", value1, value2, "studentNumber");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNull() {
            addCriterion("college_ID is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNotNull() {
            addCriterion("college_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdEqualTo(String value) {
            addCriterion("college_ID =", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotEqualTo(String value) {
            addCriterion("college_ID <>", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThan(String value) {
            addCriterion("college_ID >", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThanOrEqualTo(String value) {
            addCriterion("college_ID >=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThan(String value) {
            addCriterion("college_ID <", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThanOrEqualTo(String value) {
            addCriterion("college_ID <=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLike(String value) {
            addCriterion("college_ID like", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotLike(String value) {
            addCriterion("college_ID not like", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIn(List<String> values) {
            addCriterion("college_ID in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotIn(List<String> values) {
            addCriterion("college_ID not in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdBetween(String value1, String value2) {
            addCriterion("college_ID between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotBetween(String value1, String value2) {
            addCriterion("college_ID not between", value1, value2, "collegeId");
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