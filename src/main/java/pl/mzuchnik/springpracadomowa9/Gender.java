package pl.mzuchnik.springpracadomowa9;

public enum Gender {

    Male(0),Female(1);
    int status;
    Gender(int s)
    {
        status = s;
    }
}
