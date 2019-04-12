using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(EON.Startup))]
namespace EON
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
