package Character;

import Game.GameObject;

public class Job extends GameObject {
    /***
     * Var
     */
    private float m_Salary;
    private String m_Skills;
    /***
     * Getter
     */
    public float getSalary() {
        return m_Salary;
    }

    public String getSkills() {
        return m_Skills;
    }
    /***
     * Setter
     */
    public void setSalary(float Salary) {
        m_Salary = Salary;
    }

    public void setSkills(String Skills) {
        m_Skills = Skills;
    }
}
