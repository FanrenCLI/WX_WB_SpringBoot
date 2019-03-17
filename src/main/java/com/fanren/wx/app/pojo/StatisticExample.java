package com.fanren.wx.app.pojo;

import java.util.ArrayList;
import java.util.List;

public class StatisticExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatisticExample() {
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

        public Criteria andStudentIdIsNull() {
            addCriterion("student_ID is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("student_ID =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("student_ID <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("student_ID >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("student_ID >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("student_ID <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("student_ID <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("student_ID like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("student_ID not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("student_ID in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("student_ID not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("student_ID between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("student_ID not between", value1, value2, "studentId");
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

        public Criteria andCydIsNull() {
            addCriterion("cyd is null");
            return (Criteria) this;
        }

        public Criteria andCydIsNotNull() {
            addCriterion("cyd is not null");
            return (Criteria) this;
        }

        public Criteria andCydEqualTo(String value) {
            addCriterion("cyd =", value, "cyd");
            return (Criteria) this;
        }

        public Criteria andCydNotEqualTo(String value) {
            addCriterion("cyd <>", value, "cyd");
            return (Criteria) this;
        }

        public Criteria andCydGreaterThan(String value) {
            addCriterion("cyd >", value, "cyd");
            return (Criteria) this;
        }

        public Criteria andCydGreaterThanOrEqualTo(String value) {
            addCriterion("cyd >=", value, "cyd");
            return (Criteria) this;
        }

        public Criteria andCydLessThan(String value) {
            addCriterion("cyd <", value, "cyd");
            return (Criteria) this;
        }

        public Criteria andCydLessThanOrEqualTo(String value) {
            addCriterion("cyd <=", value, "cyd");
            return (Criteria) this;
        }

        public Criteria andCydLike(String value) {
            addCriterion("cyd like", value, "cyd");
            return (Criteria) this;
        }

        public Criteria andCydNotLike(String value) {
            addCriterion("cyd not like", value, "cyd");
            return (Criteria) this;
        }

        public Criteria andCydIn(List<String> values) {
            addCriterion("cyd in", values, "cyd");
            return (Criteria) this;
        }

        public Criteria andCydNotIn(List<String> values) {
            addCriterion("cyd not in", values, "cyd");
            return (Criteria) this;
        }

        public Criteria andCydBetween(String value1, String value2) {
            addCriterion("cyd between", value1, value2, "cyd");
            return (Criteria) this;
        }

        public Criteria andCydNotBetween(String value1, String value2) {
            addCriterion("cyd not between", value1, value2, "cyd");
            return (Criteria) this;
        }

        public Criteria andZxscIsNull() {
            addCriterion("zxsc is null");
            return (Criteria) this;
        }

        public Criteria andZxscIsNotNull() {
            addCriterion("zxsc is not null");
            return (Criteria) this;
        }

        public Criteria andZxscEqualTo(String value) {
            addCriterion("zxsc =", value, "zxsc");
            return (Criteria) this;
        }

        public Criteria andZxscNotEqualTo(String value) {
            addCriterion("zxsc <>", value, "zxsc");
            return (Criteria) this;
        }

        public Criteria andZxscGreaterThan(String value) {
            addCriterion("zxsc >", value, "zxsc");
            return (Criteria) this;
        }

        public Criteria andZxscGreaterThanOrEqualTo(String value) {
            addCriterion("zxsc >=", value, "zxsc");
            return (Criteria) this;
        }

        public Criteria andZxscLessThan(String value) {
            addCriterion("zxsc <", value, "zxsc");
            return (Criteria) this;
        }

        public Criteria andZxscLessThanOrEqualTo(String value) {
            addCriterion("zxsc <=", value, "zxsc");
            return (Criteria) this;
        }

        public Criteria andZxscLike(String value) {
            addCriterion("zxsc like", value, "zxsc");
            return (Criteria) this;
        }

        public Criteria andZxscNotLike(String value) {
            addCriterion("zxsc not like", value, "zxsc");
            return (Criteria) this;
        }

        public Criteria andZxscIn(List<String> values) {
            addCriterion("zxsc in", values, "zxsc");
            return (Criteria) this;
        }

        public Criteria andZxscNotIn(List<String> values) {
            addCriterion("zxsc not in", values, "zxsc");
            return (Criteria) this;
        }

        public Criteria andZxscBetween(String value1, String value2) {
            addCriterion("zxsc between", value1, value2, "zxsc");
            return (Criteria) this;
        }

        public Criteria andZxscNotBetween(String value1, String value2) {
            addCriterion("zxsc not between", value1, value2, "zxsc");
            return (Criteria) this;
        }

        public Criteria andLxtIsNull() {
            addCriterion("lxt is null");
            return (Criteria) this;
        }

        public Criteria andLxtIsNotNull() {
            addCriterion("lxt is not null");
            return (Criteria) this;
        }

        public Criteria andLxtEqualTo(String value) {
            addCriterion("lxt =", value, "lxt");
            return (Criteria) this;
        }

        public Criteria andLxtNotEqualTo(String value) {
            addCriterion("lxt <>", value, "lxt");
            return (Criteria) this;
        }

        public Criteria andLxtGreaterThan(String value) {
            addCriterion("lxt >", value, "lxt");
            return (Criteria) this;
        }

        public Criteria andLxtGreaterThanOrEqualTo(String value) {
            addCriterion("lxt >=", value, "lxt");
            return (Criteria) this;
        }

        public Criteria andLxtLessThan(String value) {
            addCriterion("lxt <", value, "lxt");
            return (Criteria) this;
        }

        public Criteria andLxtLessThanOrEqualTo(String value) {
            addCriterion("lxt <=", value, "lxt");
            return (Criteria) this;
        }

        public Criteria andLxtLike(String value) {
            addCriterion("lxt like", value, "lxt");
            return (Criteria) this;
        }

        public Criteria andLxtNotLike(String value) {
            addCriterion("lxt not like", value, "lxt");
            return (Criteria) this;
        }

        public Criteria andLxtIn(List<String> values) {
            addCriterion("lxt in", values, "lxt");
            return (Criteria) this;
        }

        public Criteria andLxtNotIn(List<String> values) {
            addCriterion("lxt not in", values, "lxt");
            return (Criteria) this;
        }

        public Criteria andLxtBetween(String value1, String value2) {
            addCriterion("lxt between", value1, value2, "lxt");
            return (Criteria) this;
        }

        public Criteria andLxtNotBetween(String value1, String value2) {
            addCriterion("lxt not between", value1, value2, "lxt");
            return (Criteria) this;
        }

        public Criteria andSumIsNull() {
            addCriterion("sum is null");
            return (Criteria) this;
        }

        public Criteria andSumIsNotNull() {
            addCriterion("sum is not null");
            return (Criteria) this;
        }

        public Criteria andSumEqualTo(String value) {
            addCriterion("sum =", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotEqualTo(String value) {
            addCriterion("sum <>", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThan(String value) {
            addCriterion("sum >", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThanOrEqualTo(String value) {
            addCriterion("sum >=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThan(String value) {
            addCriterion("sum <", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThanOrEqualTo(String value) {
            addCriterion("sum <=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLike(String value) {
            addCriterion("sum like", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotLike(String value) {
            addCriterion("sum not like", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumIn(List<String> values) {
            addCriterion("sum in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotIn(List<String> values) {
            addCriterion("sum not in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumBetween(String value1, String value2) {
            addCriterion("sum between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotBetween(String value1, String value2) {
            addCriterion("sum not between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andMeanIsNull() {
            addCriterion("mean is null");
            return (Criteria) this;
        }

        public Criteria andMeanIsNotNull() {
            addCriterion("mean is not null");
            return (Criteria) this;
        }

        public Criteria andMeanEqualTo(String value) {
            addCriterion("mean =", value, "mean");
            return (Criteria) this;
        }

        public Criteria andMeanNotEqualTo(String value) {
            addCriterion("mean <>", value, "mean");
            return (Criteria) this;
        }

        public Criteria andMeanGreaterThan(String value) {
            addCriterion("mean >", value, "mean");
            return (Criteria) this;
        }

        public Criteria andMeanGreaterThanOrEqualTo(String value) {
            addCriterion("mean >=", value, "mean");
            return (Criteria) this;
        }

        public Criteria andMeanLessThan(String value) {
            addCriterion("mean <", value, "mean");
            return (Criteria) this;
        }

        public Criteria andMeanLessThanOrEqualTo(String value) {
            addCriterion("mean <=", value, "mean");
            return (Criteria) this;
        }

        public Criteria andMeanLike(String value) {
            addCriterion("mean like", value, "mean");
            return (Criteria) this;
        }

        public Criteria andMeanNotLike(String value) {
            addCriterion("mean not like", value, "mean");
            return (Criteria) this;
        }

        public Criteria andMeanIn(List<String> values) {
            addCriterion("mean in", values, "mean");
            return (Criteria) this;
        }

        public Criteria andMeanNotIn(List<String> values) {
            addCriterion("mean not in", values, "mean");
            return (Criteria) this;
        }

        public Criteria andMeanBetween(String value1, String value2) {
            addCriterion("mean between", value1, value2, "mean");
            return (Criteria) this;
        }

        public Criteria andMeanNotBetween(String value1, String value2) {
            addCriterion("mean not between", value1, value2, "mean");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(String value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(String value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(String value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(String value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(String value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(String value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLike(String value) {
            addCriterion("rank like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotLike(String value) {
            addCriterion("rank not like", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<String> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<String> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(String value1, String value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(String value1, String value2) {
            addCriterion("rank not between", value1, value2, "rank");
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