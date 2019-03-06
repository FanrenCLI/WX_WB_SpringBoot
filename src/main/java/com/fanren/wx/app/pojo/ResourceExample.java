package com.fanren.wx.app.pojo;

import java.util.ArrayList;
import java.util.List;

public class ResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceExample() {
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

        public Criteria andResourceIdIsNull() {
            addCriterion("resource_id is null");
            return (Criteria) this;
        }

        public Criteria andResourceIdIsNotNull() {
            addCriterion("resource_id is not null");
            return (Criteria) this;
        }

        public Criteria andResourceIdEqualTo(Integer value) {
            addCriterion("resource_id =", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotEqualTo(Integer value) {
            addCriterion("resource_id <>", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThan(Integer value) {
            addCriterion("resource_id >", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("resource_id >=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThan(Integer value) {
            addCriterion("resource_id <", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdLessThanOrEqualTo(Integer value) {
            addCriterion("resource_id <=", value, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdIn(List<Integer> values) {
            addCriterion("resource_id in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotIn(List<Integer> values) {
            addCriterion("resource_id not in", values, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdBetween(Integer value1, Integer value2) {
            addCriterion("resource_id between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("resource_id not between", value1, value2, "resourceId");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNull() {
            addCriterion("resource_name is null");
            return (Criteria) this;
        }

        public Criteria andResourceNameIsNotNull() {
            addCriterion("resource_name is not null");
            return (Criteria) this;
        }

        public Criteria andResourceNameEqualTo(String value) {
            addCriterion("resource_name =", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotEqualTo(String value) {
            addCriterion("resource_name <>", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThan(String value) {
            addCriterion("resource_name >", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameGreaterThanOrEqualTo(String value) {
            addCriterion("resource_name >=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThan(String value) {
            addCriterion("resource_name <", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLessThanOrEqualTo(String value) {
            addCriterion("resource_name <=", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameLike(String value) {
            addCriterion("resource_name like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotLike(String value) {
            addCriterion("resource_name not like", value, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameIn(List<String> values) {
            addCriterion("resource_name in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotIn(List<String> values) {
            addCriterion("resource_name not in", values, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameBetween(String value1, String value2) {
            addCriterion("resource_name between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceNameNotBetween(String value1, String value2) {
            addCriterion("resource_name not between", value1, value2, "resourceName");
            return (Criteria) this;
        }

        public Criteria andResourceDirIsNull() {
            addCriterion("resource_dir is null");
            return (Criteria) this;
        }

        public Criteria andResourceDirIsNotNull() {
            addCriterion("resource_dir is not null");
            return (Criteria) this;
        }

        public Criteria andResourceDirEqualTo(String value) {
            addCriterion("resource_dir =", value, "resourceDir");
            return (Criteria) this;
        }

        public Criteria andResourceDirNotEqualTo(String value) {
            addCriterion("resource_dir <>", value, "resourceDir");
            return (Criteria) this;
        }

        public Criteria andResourceDirGreaterThan(String value) {
            addCriterion("resource_dir >", value, "resourceDir");
            return (Criteria) this;
        }

        public Criteria andResourceDirGreaterThanOrEqualTo(String value) {
            addCriterion("resource_dir >=", value, "resourceDir");
            return (Criteria) this;
        }

        public Criteria andResourceDirLessThan(String value) {
            addCriterion("resource_dir <", value, "resourceDir");
            return (Criteria) this;
        }

        public Criteria andResourceDirLessThanOrEqualTo(String value) {
            addCriterion("resource_dir <=", value, "resourceDir");
            return (Criteria) this;
        }

        public Criteria andResourceDirLike(String value) {
            addCriterion("resource_dir like", value, "resourceDir");
            return (Criteria) this;
        }

        public Criteria andResourceDirNotLike(String value) {
            addCriterion("resource_dir not like", value, "resourceDir");
            return (Criteria) this;
        }

        public Criteria andResourceDirIn(List<String> values) {
            addCriterion("resource_dir in", values, "resourceDir");
            return (Criteria) this;
        }

        public Criteria andResourceDirNotIn(List<String> values) {
            addCriterion("resource_dir not in", values, "resourceDir");
            return (Criteria) this;
        }

        public Criteria andResourceDirBetween(String value1, String value2) {
            addCriterion("resource_dir between", value1, value2, "resourceDir");
            return (Criteria) this;
        }

        public Criteria andResourceDirNotBetween(String value1, String value2) {
            addCriterion("resource_dir not between", value1, value2, "resourceDir");
            return (Criteria) this;
        }

        public Criteria andUploaderIdIsNull() {
            addCriterion("uploader_id is null");
            return (Criteria) this;
        }

        public Criteria andUploaderIdIsNotNull() {
            addCriterion("uploader_id is not null");
            return (Criteria) this;
        }

        public Criteria andUploaderIdEqualTo(String value) {
            addCriterion("uploader_id =", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdNotEqualTo(String value) {
            addCriterion("uploader_id <>", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdGreaterThan(String value) {
            addCriterion("uploader_id >", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdGreaterThanOrEqualTo(String value) {
            addCriterion("uploader_id >=", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdLessThan(String value) {
            addCriterion("uploader_id <", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdLessThanOrEqualTo(String value) {
            addCriterion("uploader_id <=", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdLike(String value) {
            addCriterion("uploader_id like", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdNotLike(String value) {
            addCriterion("uploader_id not like", value, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdIn(List<String> values) {
            addCriterion("uploader_id in", values, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdNotIn(List<String> values) {
            addCriterion("uploader_id not in", values, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdBetween(String value1, String value2) {
            addCriterion("uploader_id between", value1, value2, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderIdNotBetween(String value1, String value2) {
            addCriterion("uploader_id not between", value1, value2, "uploaderId");
            return (Criteria) this;
        }

        public Criteria andUploaderNameIsNull() {
            addCriterion("uploader_name is null");
            return (Criteria) this;
        }

        public Criteria andUploaderNameIsNotNull() {
            addCriterion("uploader_name is not null");
            return (Criteria) this;
        }

        public Criteria andUploaderNameEqualTo(String value) {
            addCriterion("uploader_name =", value, "uploaderName");
            return (Criteria) this;
        }

        public Criteria andUploaderNameNotEqualTo(String value) {
            addCriterion("uploader_name <>", value, "uploaderName");
            return (Criteria) this;
        }

        public Criteria andUploaderNameGreaterThan(String value) {
            addCriterion("uploader_name >", value, "uploaderName");
            return (Criteria) this;
        }

        public Criteria andUploaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("uploader_name >=", value, "uploaderName");
            return (Criteria) this;
        }

        public Criteria andUploaderNameLessThan(String value) {
            addCriterion("uploader_name <", value, "uploaderName");
            return (Criteria) this;
        }

        public Criteria andUploaderNameLessThanOrEqualTo(String value) {
            addCriterion("uploader_name <=", value, "uploaderName");
            return (Criteria) this;
        }

        public Criteria andUploaderNameLike(String value) {
            addCriterion("uploader_name like", value, "uploaderName");
            return (Criteria) this;
        }

        public Criteria andUploaderNameNotLike(String value) {
            addCriterion("uploader_name not like", value, "uploaderName");
            return (Criteria) this;
        }

        public Criteria andUploaderNameIn(List<String> values) {
            addCriterion("uploader_name in", values, "uploaderName");
            return (Criteria) this;
        }

        public Criteria andUploaderNameNotIn(List<String> values) {
            addCriterion("uploader_name not in", values, "uploaderName");
            return (Criteria) this;
        }

        public Criteria andUploaderNameBetween(String value1, String value2) {
            addCriterion("uploader_name between", value1, value2, "uploaderName");
            return (Criteria) this;
        }

        public Criteria andUploaderNameNotBetween(String value1, String value2) {
            addCriterion("uploader_name not between", value1, value2, "uploaderName");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(String value) {
            addCriterion("upload_time =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(String value) {
            addCriterion("upload_time <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(String value) {
            addCriterion("upload_time >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(String value) {
            addCriterion("upload_time >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(String value) {
            addCriterion("upload_time <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(String value) {
            addCriterion("upload_time <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLike(String value) {
            addCriterion("upload_time like", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotLike(String value) {
            addCriterion("upload_time not like", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<String> values) {
            addCriterion("upload_time in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<String> values) {
            addCriterion("upload_time not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(String value1, String value2) {
            addCriterion("upload_time between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(String value1, String value2) {
            addCriterion("upload_time not between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberIsNull() {
            addCriterion("download_number is null");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberIsNotNull() {
            addCriterion("download_number is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberEqualTo(String value) {
            addCriterion("download_number =", value, "downloadNumber");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberNotEqualTo(String value) {
            addCriterion("download_number <>", value, "downloadNumber");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberGreaterThan(String value) {
            addCriterion("download_number >", value, "downloadNumber");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberGreaterThanOrEqualTo(String value) {
            addCriterion("download_number >=", value, "downloadNumber");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberLessThan(String value) {
            addCriterion("download_number <", value, "downloadNumber");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberLessThanOrEqualTo(String value) {
            addCriterion("download_number <=", value, "downloadNumber");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberLike(String value) {
            addCriterion("download_number like", value, "downloadNumber");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberNotLike(String value) {
            addCriterion("download_number not like", value, "downloadNumber");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberIn(List<String> values) {
            addCriterion("download_number in", values, "downloadNumber");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberNotIn(List<String> values) {
            addCriterion("download_number not in", values, "downloadNumber");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberBetween(String value1, String value2) {
            addCriterion("download_number between", value1, value2, "downloadNumber");
            return (Criteria) this;
        }

        public Criteria andDownloadNumberNotBetween(String value1, String value2) {
            addCriterion("download_number not between", value1, value2, "downloadNumber");
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