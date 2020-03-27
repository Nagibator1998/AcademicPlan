export class IndependentWorkForm {
  id: number;
  text: string;

  static clone(independentWorkForm: IndependentWorkForm): IndependentWorkForm{
    let clonedIndependentWorkForm = new IndependentWorkForm();
    clonedIndependentWorkForm.id = independentWorkForm.id;
    clonedIndependentWorkForm.text = independentWorkForm.text;
    return clonedIndependentWorkForm;
  }
}
