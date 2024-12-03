package Adhikary.external.domain;


import Adhikary.X.PersonImmutable;

import java.util.Arrays;

public class LivingPerson extends PersonImmutable {

    public LivingPerson(String name,PersonImmutable[] kids)
    {
        super(name,null,kids == null ? new PersonImmutable[0] : Arrays.copyOf(kids,10));
    }

    public LivingPerson(PersonImmutable person)
    {
        super(person);
    }


    @Override
    public String getDob()
    {
        return null;
    }

}
