import { KdoNoelPage } from './app.po';

describe('kdo-noel App', () => {
  let page: KdoNoelPage;

  beforeEach(() => {
    page = new KdoNoelPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
