export interface IDmCqbh {
  id?: string;
  ma?: string;
  ten?: string;
}

export class DmCqbh implements IDmCqbh {
  constructor(public id?: string, public ma?: string, public ten?: string) {}
}
