export class Standard {
  id: number;
  name: string;

  static clone(standard: Standard): Standard {
    let cloneStandard: Standard = new Standard();
    cloneStandard.id = standard.id;
    cloneStandard.name = standard.name;
    return cloneStandard;
  }
}
