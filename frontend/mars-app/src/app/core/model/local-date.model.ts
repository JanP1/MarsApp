export class LocalDate {
  readonly year: number;
  readonly month: number;
  readonly day: number;

  constructor(year: number, month: number, day: number) {
    this.year = year;
    this.month = month;
    this.day = day;
  }

  static fromString(dateString: string): LocalDate {
    const [y, m, d] = dateString.split('-').map(Number);
    return new LocalDate(y, m, d);
  }

  toString(): string {
    return `${this.year}-${String(this.month).padStart(2, '0')}-${String(this.day).padStart(2, '0')}`;
  }
}

