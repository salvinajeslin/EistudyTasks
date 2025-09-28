package model;

public class Student {
    private final String name;
    private final int age;
    private final String department;
    private final double gpa;
    private final String email;

    // Private constructor - only Builder can create
    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.department = builder.department;
        this.gpa = builder.gpa;
        this.email = builder.email;
    }

    // Static inner Builder class
    public static class Builder {
        private String name;
        private int age;
        private String department;
        private double gpa;
        private String email;

        public Builder setName(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty!");
            }
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            if (age <= 0) {
                throw new IllegalArgumentException("Age must be positive!");
            }
            this.age = age;
            return this;
        }

        public Builder setDepartment(String department) {
            if (department == null || department.trim().isEmpty()) {
                throw new IllegalArgumentException("Department cannot be empty!");
            }
            this.department = department;
            return this;
        }

        public Builder setGpa(double gpa) {
            if (gpa < 0.0 || gpa > 10.0) {
                throw new IllegalArgumentException("GPA must be between 0.0 and 10.0!");
            }
            this.gpa = gpa;
            return this;
        }

        public Builder setEmail(String email) {
            if (email == null || !email.contains("@")) {
                throw new IllegalArgumentException("Invalid email address!");
            }
            this.email = email;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Student [Name=%s, Age=%d, Department=%s, GPA=%.2f, Email=%s]",
                name, age, department, gpa, email
        );
    }
}
