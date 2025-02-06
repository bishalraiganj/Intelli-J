package Adhikary.X.sealed;

public sealed abstract class SpecialAbstractClass permits  FinalKid,SealedKid,NonSealedKid, SpecialAbstractClass.Kid  {


    final class Kid extends SpecialAbstractClass{}


}
