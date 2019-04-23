using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(BaseDeDatosWarioSoft.Startup))]
namespace BaseDeDatosWarioSoft
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
