package com.school.modules.StudentEnrollmentRegistration.enums;


public enum ApplicationStatus {
    PENDING("قيد الانتظار", "Pending", "text-warning"),     // Yellow text
    VERIFIED("تم التحقق", "Verified", "text-success"),      // Green text
    REJECTED("مرفوض", "Rejected", "text-danger"),           // Red text
    ACCEPTED("مقبول", "Accepted", "text-primary");

    private final String nameAr;
    private final String nameEn;
    private final String uiColor;

    ApplicationStatus(String nameAr, String nameEn, String uiColor) {
        this.nameAr = nameAr;
        this.nameEn = nameEn;
        this.uiColor = uiColor;
    }

    public String getNameAr() {
        return nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getUiColor() {
        return uiColor;
    }
}
